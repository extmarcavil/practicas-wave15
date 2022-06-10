package com.mercadolibre.fp_be_java_hisp_w15_g06.service;

import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.InboundOrderRequestDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.InboundOrderResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IInboundOrderService {

    ResponseEntity<InboundOrderResponseDTO> saveInboundOrder(InboundOrderRequestDTO inboundOrderRequest, String username);
    ResponseEntity<InboundOrderResponseDTO> updateInboundOrder(InboundOrderRequestDTO inboundOrderRequest, String username);
}
