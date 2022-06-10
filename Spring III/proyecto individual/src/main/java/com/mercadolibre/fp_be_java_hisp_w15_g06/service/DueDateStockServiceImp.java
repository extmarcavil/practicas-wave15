package com.mercadolibre.fp_be_java_hisp_w15_g06.service;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.BatchStockDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO.BatchStockListResponseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO.BatchStockResponseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.enums.Category;
import com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions.InvalidOrderException;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Batch;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.InboundOrder;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Section;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.IBatchRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.IInboundOrderRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.ISectionRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DueDateStockServiceImp implements IDueDateStockService {

    private final IBatchRepository iBatchRepository;
    private final IInboundOrderRepository inboundRepository;
    private final ISectionRepository sectionRepository;

    private ModelMapper mapper;

    public DueDateStockServiceImp(IBatchRepository iBatchRepository, IInboundOrderRepository inboundRepository, ISectionRepository sectionRepository) {
        this.iBatchRepository = iBatchRepository;
        this.inboundRepository = inboundRepository;
        this.sectionRepository = sectionRepository;
        mapper = new ModelMapper();
        //ModelMapper mapper = this.mapper.registerModule(new JavaTimeModule());
    }

    /**
     * Busca todos los batch entre la fecha de hoy y la de vencimiento segun la cantidad de dias brindado
     *
     * @param cantDays, order, category
     * @return BatchStockResponseDTO
     */

    @Override
    public BatchStockListResponseDTO BatchStockDueDate(int cantDays, String order, Category category) {

        validateDateOrdering(order);

        LocalDate today = LocalDate.now();
        LocalDate dueDate = today.plusDays(cantDays);

        List<Batch> stocks = iBatchRepository.findAllByDueDateBetween(today, dueDate);


        Type listType = new TypeToken<List<BatchStockDTO>>() {
        }.getType();
        List<BatchStockDTO> batchStockResponseDTOS = stocks.stream().map(batch -> {
            BatchStockDTO batchStock = mapper.map(batch, BatchStockDTO.class);
            batchStock.setDueDate(batch.getDueDate());
            return batchStock;
        }).collect(Collectors.toList());

        if (order.equalsIgnoreCase("date_asc"))
            batchStockResponseDTOS.sort(Comparator.comparing(BatchStockDTO::getDueDate));
        else
            batchStockResponseDTOS.sort(Comparator.comparing(BatchStockDTO::getDueDate).reversed());


        Long inboundId = 0L;

        //Modificar para utilizar todos los inbound
        //for (BatchStockDTO b : batchStockResponseDTOS) {
        //    inboundId = b.getInboundId();
        //}

        List<BatchStockDTO> categoryBatchStock = new ArrayList<>();
        BatchStockListResponseDTO batchStock;
      
       if(order.equalsIgnoreCase("date_asc"))
           batchStockResponseDTOS.sort(Comparator.comparing(BatchStockDTO::getDueDate));
       else
           batchStockResponseDTOS.sort(Comparator.comparing(BatchStockDTO::getDueDate).reversed());

        //Validar que category se halla recibido y filtrar la lista de acuerdo a la misma.
        if(category!=null){
            for (BatchStockDTO b : batchStockResponseDTOS) {
                inboundId = b.getInboundId();

                InboundOrder inboundOrderBatch =  inboundRepository.findById(inboundId).get();

                if(inboundOrderBatch.getSection().getCategory().equals(category)){
                    categoryBatchStock.add(b);
                }
            }
              batchStock = new BatchStockListResponseDTO(categoryBatchStock);

        } else{
            batchStock = new BatchStockListResponseDTO(batchStockResponseDTOS);
        }

        return batchStock;
    }

    private void validateDateOrdering(String order) {
        if (!(order.equals("date_asc") || order.equals("date_desc") || order.isEmpty()))
            throw new InvalidOrderException();
    }

}
