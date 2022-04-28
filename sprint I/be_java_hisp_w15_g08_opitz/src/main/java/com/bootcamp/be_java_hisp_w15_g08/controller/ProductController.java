package com.bootcamp.be_java_hisp_w15_g08.controller;

import com.bootcamp.be_java_hisp_w15_g08.dto.request.PromoProductDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.FollowersCountDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.PromoProductsCountDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.PromoProductsListDTO;
import com.bootcamp.be_java_hisp_w15_g08.service.IProductService;
import com.bootcamp.be_java_hisp_w15_g08.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/promo-post")
public class ProductController {
    IUserService service;
    IProductService productService;

    public ProductController(IUserService service, IProductService productService){
        this.service = service;
        this.productService = productService;
    }

    @PostMapping()
    public ResponseEntity<?> newPromoProduct(@RequestBody PromoProductDTO product){
        System.out.println(product.isHas_promo());
        productService.addPromoProduct(product);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<PromoProductsCountDTO> getPromoProductsCount(@RequestParam Integer user_id){
        System.out.println(user_id);
        PromoProductsCountDTO promoCount = productService.getPromoProductsCount(user_id);
        return new ResponseEntity<>(promoCount, HttpStatus.ACCEPTED);
    }

    @GetMapping("/list")
    public ResponseEntity<PromoProductsListDTO> getSellerProducts(@RequestParam Integer user_id){
        System.out.println(user_id);
        PromoProductsListDTO productList = productService.getSellersProducts(user_id);
        return new ResponseEntity<>(productList, HttpStatus.ACCEPTED);
    }

}
