package com.mercadolibre.fp_be_java_hisp_w15_g05.controller;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.request.InboundOrderRequestDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.InboundOrderResponseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.service.IInboundOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fresh-products/inboundorder")
public class InboundOrderController {

    private IInboundOrderService service;

    public InboundOrderController(IInboundOrderService service) {
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity<InboundOrderResponseDTO> insertBatch(@RequestHeader("Authorization") String token, @RequestBody InboundOrderRequestDTO body) {
        return new ResponseEntity<>(service.saveInboundOrder(body, token), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<InboundOrderResponseDTO> updateBatch(@RequestHeader("Authorization") String token, @RequestBody InboundOrderRequestDTO body) {
        return new ResponseEntity<>(service.updateInboundOrder(body, token), HttpStatus.CREATED);
}
}
