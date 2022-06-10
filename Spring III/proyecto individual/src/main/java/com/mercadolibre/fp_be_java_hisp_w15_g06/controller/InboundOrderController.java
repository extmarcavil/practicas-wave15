package com.mercadolibre.fp_be_java_hisp_w15_g06.controller;

import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.InboundOrderDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.InboundOrderRequestDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.InboundOrderResponseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.service.IInboundOrderService;
import com.mercadolibre.fp_be_java_hisp_w15_g06.service.securitySession.IServiceSession;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/fresh-products/inboundorder")
@Validated
public class InboundOrderController {

    private final IInboundOrderService inboundOrderService;
    private final IServiceSession sessionService;

    public InboundOrderController(IInboundOrderService inboundOrderService, IServiceSession sessionService) {
        this.inboundOrderService = inboundOrderService;
        this.sessionService = sessionService;
    }

    @PostMapping("")
    public ResponseEntity<InboundOrderResponseDTO> saveInboundOrder(@Valid @RequestBody InboundOrderRequestDTO inboundOrderRequest,
                                                                    @RequestHeader(value="Authorization") String token) {

        String username = sessionService.getUsername(token);
        return inboundOrderService.saveInboundOrder(inboundOrderRequest, username);
    }

    @PutMapping("")
    public ResponseEntity<InboundOrderResponseDTO> updateInboundOrder(@RequestBody InboundOrderRequestDTO inboundOrderRequest,
                                                                      @RequestHeader(value="Authorization") String token) {
        String username = sessionService.getUsername(token);
        return inboundOrderService.updateInboundOrder(inboundOrderRequest, username);
    }
}
