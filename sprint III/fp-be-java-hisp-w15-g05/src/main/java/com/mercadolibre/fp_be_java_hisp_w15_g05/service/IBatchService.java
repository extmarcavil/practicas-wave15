package com.mercadolibre.fp_be_java_hisp_w15_g05.service;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.BatchDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Batch;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Product;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Section;

import java.util.List;

public interface IBatchService {

    Batch getBatch(Integer id);
    void validateBatchDoesNotExist(Integer id);
    Batch saveBatch(BatchDTO batchDTO, Product product, Section section);
    List<Batch> saveBatchList(List<BatchDTO> batchsDTO, Section section);

    Batch validateBatchExistance(Integer id);
    Batch updateBatch(BatchDTO batchDTO, Product product, Section section);
    List<Batch> updateBatchList(List<BatchDTO> batchsDTO, Section section);
    List<Batch> getExistingBatchs(List<BatchDTO> batchsDTO);
}
