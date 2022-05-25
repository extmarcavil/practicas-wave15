package com.bootcamp.ejercitacion.controller;

import com.bootcamp.ejercitacion.dto.ProductDTO;
import com.bootcamp.ejercitacion.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("")
    public ResponseEntity<?> createProduct (@RequestBody ProductDTO product ) {
        return new ResponseEntity<>(productService.saveProduct(product), OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateProduct (@PathVariable String id, @RequestBody ProductDTO product ) {
        return new ResponseEntity<>(productService.updateProduct(id,product), OK);
    }
}
