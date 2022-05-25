package com.example.exampleclavescompuestas.controller;

import com.example.exampleclavescompuestas.model.Purchase;
import com.example.exampleclavescompuestas.service.IPurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseController {
    private final IPurchaseService service;

    public PurchaseController(IPurchaseService service) {
        this.service = service;
    }

    @PostMapping("/agregar_compra")
    ResponseEntity<Purchase> newCompra(@RequestBody Purchase newPurchase){
        return new ResponseEntity<>(service.save(newPurchase), HttpStatus.OK);
    }
}
