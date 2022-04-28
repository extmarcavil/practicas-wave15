package com.sprint1.be_java_hisp_w15_g03.controller;

import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationPromoDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.*;
import com.sprint1.be_java_hisp_w15_g03.service.IProductService;
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

    /**
     * US04
     */
    @PostMapping("/post")
    public ResponseEntity<?> savePublication(@RequestBody PublicationDTO publication) {
        productService.savePublication(publication);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * US04 - US09
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<SellerPListDTO> getLastPublications(@PathVariable int userId,
                                                              @RequestParam(required = false) String order) {

        return new ResponseEntity<>(productService.getLastPublication(userId, order), HttpStatus.OK);
    }

    /**
     * US10
     */
    @PostMapping("/promo-post")
    public ResponseEntity<HttpStatus> savePromoPublication(@RequestBody PublicationPromoDTO publication){

        productService.savePromoPublication(publication);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    /**
     * US11
     */
    @GetMapping("/promo-post/count")
    public ResponseEntity<SellerPromoCountDTO> getPromoPostCount(@RequestParam(name = "user_id") Integer sellerId) {
       return new ResponseEntity<>(productService.getPromoCount(sellerId), HttpStatus.OK);
    }

    /**
     * US12
     */
    @GetMapping("/promo-post/list")
    public ResponseEntity<SellerPPromoListDTO> getPromoPostList(@RequestParam(name = "user_id") Integer sellerId,
                                                                @RequestParam(required = false) String order) {
        return new ResponseEntity<>(productService.getPromoList(sellerId,order), HttpStatus.OK);
    }



}
