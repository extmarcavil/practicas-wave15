package com.example.be_java_hisp_w15_g05.controller;

import com.example.be_java_hisp_w15_g05.dto.*;
import com.example.be_java_hisp_w15_g05.service.IProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
public class ProductsController {

    private IProductsService productsService;

    public ProductsController(IProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping("/post")
    public ResponseEntity<ResCreatePostDTO> createPost(@RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(productsService.createPost(postDTO), HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<ResCreatePostDTO> createPostPromo(@RequestBody PostPromoDTO postPromoDTO) {
        return new ResponseEntity<>(productsService.createPromoPost(postPromoDTO), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ResPostListDTO> queryPost(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(productsService.getPostFollowed(userId, order), HttpStatus.OK);

    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<ResPostPromoCountDTO> promoPostCount(@RequestParam Integer user_id) {
        return new ResponseEntity<>(productsService.getPostPromoCount(user_id), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<ResPostPromoListDTO> promoPostList(
            @RequestParam Integer user_id,
            @RequestParam(required = false, defaultValue = "") String order) {
        return new ResponseEntity<>(productsService.getPostPromoList(user_id, order), HttpStatus.OK);
    }

    @GetMapping("/post/{userId}/all")
    public ResponseEntity<ResPostPromoListDTO> allPost(
            @PathVariable int userId,
            @RequestParam(required = false, defaultValue = "") String order) {
        return new ResponseEntity<>(productsService.getAllPost(userId, order), HttpStatus.OK);
    }
}
