package com.mercadolibre.fp_be_java_hisp_w15_g06.utils;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.BatchStockDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO.BatchStockListResponseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Batch;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.InboundOrder;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Product;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class BatchFactory {

    private static final Product product = new Product(1L, "yogurt");
    //private static final Batch batch = new Batch(2L, 5D, 5D, 100, 100, LocalDateTime.now(), LocalDate.now().plusDays(60), product,new InboundOrder(1L));


    static ModelMapper mapper = new ModelMapper();

    //Canasta con la manzana roja.
    public static BatchStockListResponseDTO getBatchList(){
        List<Batch>batches = new ArrayList<>();
       // batches.add(batch);

        List<BatchStockDTO> batchStockDTOS = batches.stream().map((batch) -> mapper.map(batch,BatchStockDTO.class)).collect(Collectors.toList());

        BatchStockListResponseDTO batchStockResponseDTO = new BatchStockListResponseDTO(batchStockDTOS);

        return batchStockResponseDTO;
    }

    public static List<Batch> batchList(){
        List<Batch> list = new ArrayList<>();

       // list.add(batch);

        return list;
    }
}
