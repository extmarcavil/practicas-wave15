package com.mercadolibre.fp_be_java_hisp_w15_g05.service;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.request.InboundOrderRequestDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.InboundOrderResponseDTO;

public interface IInboundOrderService {

    InboundOrderResponseDTO saveInboundOrder(InboundOrderRequestDTO inboundOrderRequest, String token);
    InboundOrderResponseDTO updateInboundOrder(InboundOrderRequestDTO inboundOrderRequest, String token);
}
