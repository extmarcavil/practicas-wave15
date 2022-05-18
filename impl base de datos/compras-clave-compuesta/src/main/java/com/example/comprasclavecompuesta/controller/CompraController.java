package com.example.comprasclavecompuesta.controller;

import com.example.comprasclavecompuesta.model.Compra;
import com.example.comprasclavecompuesta.service.ICompraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/compra")
public class CompraController {

    private ICompraService compraService;

    public CompraController(ICompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping()
    ResponseEntity<String> newCompra(@RequestBody Compra newCompra){
        compraService.save(newCompra);
        return new ResponseEntity<>("Compra creada", HttpStatus.OK);
    }
}
