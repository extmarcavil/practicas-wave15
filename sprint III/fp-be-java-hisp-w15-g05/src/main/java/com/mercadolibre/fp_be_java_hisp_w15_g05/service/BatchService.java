package com.mercadolibre.fp_be_java_hisp_w15_g05.service;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.BatchDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions.InvalidFieldException;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Batch;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Product;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Section;
import com.mercadolibre.fp_be_java_hisp_w15_g05.repository.BatchRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BatchService implements IBatchService {

    private BatchRepository batchRepository;
    private IProductService productService;
    private ModelMapper modelMapper;

    public BatchService(BatchRepository batchRepository, IProductService productService) {
        this.batchRepository = batchRepository;
        this.productService = productService;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Batch getBatch(Integer id) {
        return batchRepository.findByBatch_number(id);
    }

    @Override
    public void validateBatchDoesNotExist(Integer id) {
        if(getBatch(id) != null)
            throw new InvalidFieldException("El lote Nº" + id + " ya se encuentra registrado");
    }

    @Override
    public Batch validateBatchExistance(Integer id) {
        Batch batch = getBatch(id);
        if(batch == null)
            throw new InvalidFieldException("El lote Nº" + id + " no se encuentra registrado");
        return batch;
    }

    @Override
    public List<Batch> getExistingBatchs(List<BatchDTO> batchsDTO) {
        List<Batch> batchs = new ArrayList<>();
        for(BatchDTO batchDTO: batchsDTO) {
            Batch batch = validateBatchExistance(batchDTO.getBatch_number());
            batchs.add(batch);
        }
        return batchs;
    }

    @Override
    public Batch saveBatch(BatchDTO batchDTO, Product product, Section section) {
        validateBatchDoesNotExist(batchDTO.getBatch_number());
        Batch batch = modelMapper.map(batchDTO, Batch.class);
        batch.setProduct(product);
        batch.setSection(section);
        batchRepository.save(batch);
        return batch;
    }

    @Override
    public Batch updateBatch(BatchDTO batchDTO, Product product, Section section) {
        validateBatchExistance(batchDTO.getBatch_number());
        Batch batch = modelMapper.map(batchDTO, Batch.class);
        batch.setProduct(product);
        batch.setSection(section);
        batchRepository.save(batch);
        return batch;
    }



    @Override
    public List<Batch> saveBatchList(List<BatchDTO> batchsDTO, Section section) {
        List<Batch> batchs = new ArrayList<>();
        for(BatchDTO batchDTO: batchsDTO) {
            Product product = productService.findById(batchDTO.getProduct_id());
            Batch batch = saveBatch(batchDTO, product, section);
            batchs.add(batch);
        }
        return batchs;
    }

    @Override
    public List<Batch> updateBatchList(List<BatchDTO> batchsDTO, Section section) {
        List<Batch> batchs = new ArrayList<>();
        for(BatchDTO batchDTO: batchsDTO) {
            Product product = productService.findById(batchDTO.getProduct_id());
            Batch batch = updateBatch(batchDTO, product, section);
            batchs.add(batch);
        }
        return batchs;
    }


}
