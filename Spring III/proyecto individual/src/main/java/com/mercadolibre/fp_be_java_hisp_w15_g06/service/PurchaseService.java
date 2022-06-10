package com.mercadolibre.fp_be_java_hisp_w15_g06.service;

import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.ProductDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.PurchaseOrderDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.SuccessfulOrderDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.enums.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PurchaseService {

    ResponseEntity<List<ProductDTO>> findProducts();

    ResponseEntity<List<ProductDTO>> findProductsByCategory(Category category);

    ResponseEntity<SuccessfulOrderDTO> createOrder(PurchaseOrderDTO purchaseOrderDto);

    ResponseEntity<List<ProductDTO>> findProductsByOrder(Long idOrder);

    PurchaseOrderDTO modifyOrder(Long idOrder, PurchaseOrderDTO requestProductDTO);

}
