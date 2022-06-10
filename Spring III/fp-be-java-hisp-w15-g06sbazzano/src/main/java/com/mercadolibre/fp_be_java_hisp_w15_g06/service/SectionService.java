package com.mercadolibre.fp_be_java_hisp_w15_g06.service;

import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO.BatchSectionResponseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO.BatchStockResponseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Batch;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SectionService {

    ResponseEntity<List<BatchSectionResponseDTO>> getAllBatchBySection(Long idSection);
}
