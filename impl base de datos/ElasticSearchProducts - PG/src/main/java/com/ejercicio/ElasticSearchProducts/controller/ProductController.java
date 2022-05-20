package com.ejercicio.ElasticSearchProducts.controller;

import com.ejercicio.ElasticSearchProducts.dto.request.ProductRequestDTO;
import com.ejercicio.ElasticSearchProducts.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> addNewProduct (@RequestBody ProductRequestDTO product){
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> listProducts () {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/modify/{name}")
    public ResponseEntity<?> modifyProductByName (@PathVariable String name, @RequestBody ProductRequestDTO product){
        return new ResponseEntity<>(productService.modifyProduct(name, product), HttpStatus.OK);
    }
}
