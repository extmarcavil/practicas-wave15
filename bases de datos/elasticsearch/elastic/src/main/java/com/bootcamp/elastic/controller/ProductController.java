package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.dto.EmployeeDto;
import com.bootcamp.elastic.dto.ProductDto;
import com.bootcamp.elastic.service.IEmployeeService;
import com.bootcamp.elastic.service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("product")
public class ProductController {

    private IProductService productService;

    public ProductController(IProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto product){
        return ResponseEntity.ok().body(productService.save(product));
    }
}
