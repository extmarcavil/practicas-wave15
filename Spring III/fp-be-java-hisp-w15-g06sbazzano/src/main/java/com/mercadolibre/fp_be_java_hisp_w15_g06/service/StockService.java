package com.mercadolibre.fp_be_java_hisp_w15_g06.service;

import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO.BatchStockResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StockService {

    ResponseEntity<List<BatchStockResponseDTO>> listAllBatchByProduct(Long idProduct, String order);
}
