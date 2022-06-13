package com.mercadolibre.fp_be_java_hisp_w15_g05.service;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.BatchDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Batch;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Section;

import java.util.List;

public interface ISectionService {

    Section getExistingSection(Integer id);
    void updateSectionSize(Integer id, Integer batchStockSize);
    void validateHasSpaceAvailable(Integer currentSize, Integer totalSize, Integer batchStockSize);
    void validateCorrectSectionType(Integer id, List<BatchDTO> batchs);
    Integer validateSectionSize(List<Batch> batchs, Integer sectionCode);
    void updateSectionSizeChanged(List<Batch> batchs, Integer sectionCode);
}
