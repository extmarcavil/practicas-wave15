package com.sprint1.be_java_hisp_w15_g03_acosta.controller;

import com.sprint1.be_java_hisp_w15_g03_acosta.dto.request.PublicationDTO;
import com.sprint1.be_java_hisp_w15_g03_acosta.dto.response.SellerPListDTO;
import com.sprint1.be_java_hisp_w15_g03_acosta.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Validated
@RestController
@RequestMapping("/products")
public class ProductController {

    IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/post")
    public ResponseEntity<?> savePublication(@RequestBody @Valid PublicationDTO publication) {
        productService.savePublication(publication);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<SellerPListDTO> getLastPublications(@PathVariable @Min(value = 1, message = "El id debe ser mayor a cero.") int userId,
                                                              @RequestParam(required = false) String order) {

        return new ResponseEntity<>(productService.getLastPublication(userId, order), HttpStatus.OK);
    }

}
