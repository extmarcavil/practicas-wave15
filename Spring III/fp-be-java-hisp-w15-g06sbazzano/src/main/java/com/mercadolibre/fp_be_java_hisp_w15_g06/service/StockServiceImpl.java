package com.mercadolibre.fp_be_java_hisp_w15_g06.service;


import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO.BatchStockResponseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions.InvalidOrderException;
import com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions.BatchNotFoundException;
import com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions.ProductNotFoundException;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Batch;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Product;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.BatchRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService {

    private final BatchRepository batchRepository;
    private final ProductRepository productRepository;

    private ModelMapper mapper;

    public StockServiceImpl(BatchRepository batchRepository, ProductRepository productRepository){
        this.batchRepository = batchRepository;
        this.productRepository = productRepository;
        mapper = new ModelMapper();
    }

    //CORROBORAR QUE EL PRODUCTO EXISTA


    @Override
    public ResponseEntity<List<BatchStockResponseDTO>> listAllBatchByProduct(Long idProduct, String order) {

        validateOrdering(order);

        Product products = productRepository.findProductById(idProduct);

        List<Batch> batches = batchRepository.findAllByProduct(products);


        if (batches.isEmpty()) {
            throw new BatchNotFoundException();
        }
        for (Batch batch : batches) {
            boolean productBatch = addValidationsFor(batch, batch.getDueDate());

            if (order.equals("L") && productBatch) {
                batches.sort(Comparator.comparing(Batch::getId));
            } else if (order.equals("C") && productBatch)  {
                batches.sort(Comparator.comparing(Batch::getCurrentQuantity));
            } else if (order.equals("F") && productBatch) {
                batches.sort(Comparator.comparing(Batch::getDueDate));
            } else if (productBatch) {
                batches.sort(Comparator.comparing(Batch::getDueDate));
            }
        }
       return new ResponseEntity<>(batches.stream()
                .map(BatchStockResponseDTO::from)
                .collect(Collectors.toList()), HttpStatus.OK);
   }

    private boolean addValidationsFor(Batch batch, LocalDate requestDate) {
        Product prod = productRepository.findAll().stream()
                .filter(x -> x.getId() == batch.getProduct().getId())
                .findFirst().orElseThrow(() -> new ProductNotFoundException(batch.getProduct().getId()));
        boolean theProductHasNotExpired = validateDueDateFrom(batch.getDueDate(), requestDate);
        return theProductHasNotExpired;
    }

    private boolean validateDueDateFrom(LocalDate batchDueDate, LocalDate requestDate) {
        Period period =  Period.between(batchDueDate, requestDate);
        return period.getDays() > 21;
    }

    private void validateOrdering(String order) {
        if (!(order.equals("L") || order.equals("C") || order.equals("F") || order.isEmpty()))
            throw new InvalidOrderException();
    }

}
