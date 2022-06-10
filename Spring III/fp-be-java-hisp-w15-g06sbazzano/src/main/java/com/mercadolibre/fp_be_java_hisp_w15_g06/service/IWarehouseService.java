package com.mercadolibre.fp_be_java_hisp_w15_g06.service;

import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO.ProductWarehouseDTO;
import org.springframework.http.ResponseEntity;

public interface IWarehouseService {

    ResponseEntity<ProductWarehouseDTO> findAllProductsInWarehouse(Long productId, String username);
}
