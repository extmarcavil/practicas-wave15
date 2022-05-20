package com.example.productos.controller;

import com.example.productos.domain.Producto;
import com.example.productos.service.IProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    private final IProductoService productoService;

    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    ResponseEntity<Producto> newEmpleado(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.save(producto));
    }

    @GetMapping
    ResponseEntity<?> findAll(){
        return ResponseEntity.ok(productoService.findAll());
    }
}
