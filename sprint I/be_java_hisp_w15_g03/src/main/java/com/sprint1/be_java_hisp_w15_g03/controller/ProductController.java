package com.sprint1.be_java_hisp_w15_g03.controller;

import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationDTO;
import com.sprint1.be_java_hisp_w15_g03.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/post")
    public ResponseEntity<?> savePublication(@RequestBody PublicationDTO publication){
        productService.savePublication(publication);
        return new ResponseEntity<>( HttpStatus.OK);
    }

}
