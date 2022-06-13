package com.mercadolibre.fp_be_java_hisp_w15_g05.controller;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.request.ReqSavePurchaseOrderDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.service.IPurchaseOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/api/v1/fresh-products")
public class OrderController {

    private final IPurchaseOrderService orderService;

    public OrderController(IPurchaseOrderService oderService) {
        this.orderService = oderService;
    }

    @GetMapping("/orders/{idOrder}")
    public ResponseEntity<?> getProductListOrder(
            @Positive(message = "El numero de la orden debe ser mayor a 0.")
            @NotNull(message = "El numero de la orden no debe ser nulo.")
            @PathVariable
            Integer idOrder,
            @RequestHeader("Authorization")
            String token){
        return  ResponseEntity.ok().body(orderService.getListProducts(idOrder,token));
    }
    @PostMapping("/orders")
    public ResponseEntity<?> saveOrder(@RequestHeader("Authorization") String token,@RequestBody ReqSavePurchaseOrderDTO savePurchaseOrderDTO){
        //TODO OJO QUE CAMBIA LA FIRMA A COMO ESTA EN LA COLE DE POSTMAN
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.saveOrder(savePurchaseOrderDTO, token));
    }

    @PutMapping("/orders/{idOrder}")
    public ResponseEntity<?> modifyOrder(
            @RequestHeader("Authorization") String token,
            @RequestBody ReqSavePurchaseOrderDTO savePurchaseOrderDTO,
            @PathVariable Integer idOrder){
        //TODO OJO QUE CAMBIA LA FIRMA A COMO ESTA EN LA COLE DE POSTMAN
        return ResponseEntity.status(HttpStatus.OK).body(orderService.modifyOrder(idOrder, savePurchaseOrderDTO,token));
    }
}
