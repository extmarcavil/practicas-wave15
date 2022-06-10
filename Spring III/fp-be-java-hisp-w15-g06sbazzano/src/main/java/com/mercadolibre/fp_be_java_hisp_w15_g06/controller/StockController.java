package com.mercadolibre.fp_be_java_hisp_w15_g06.controller;

import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO.BatchStockResponseDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.service.StockService;
import com.mercadolibre.fp_be_java_hisp_w15_g06.service.securitySession.IServiceSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {

    private final StockService stockService;
    private final IServiceSession iServiceSession;

    @Autowired
    public StockController(StockService stockService, IServiceSession iServiceSession) {
        this.stockService = stockService;
        this.iServiceSession = iServiceSession;
    }

   @GetMapping("/api/v1/fresh-products/{idProduct}/batch/list")
    public ResponseEntity<List<BatchStockResponseDTO>> findAllBatchByProduct(@RequestHeader(value= "Authorization") String authorization,
                                                                             @PathVariable Long idProduct,
                                                                             @RequestParam(required=false, defaultValue = "") String order){
       String username = iServiceSession.getUsername(authorization);
        return stockService.listAllBatchByProduct(idProduct, order);
    }
}

