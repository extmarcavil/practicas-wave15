package com.example.be_java_hisp_w15_g05.controller;

import com.example.be_java_hisp_w15_g05.dto.*;
import com.example.be_java_hisp_w15_g05.service.IProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductsController {

    private IProductsService productsService;

    public ProductsController(IProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping("/products/post")
    public ResponseEntity<ResCreatePostDTO> createPost(@RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(productsService.createPost(postDTO), HttpStatus.OK);
    }

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<ResPostListDTO> getPostFollowed(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(productsService.getPostFollowed(userId, order), HttpStatus.OK);
    }

    @PostMapping("/products/promo-post")
    public ResponseEntity<ResCreatePostDTO> createPromoPost(@RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(productsService.createPost(postDTO), HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<ResPromoPostsDTO> getCountPromoPosts(@RequestParam int userId) {
        return new ResponseEntity<>(productsService.getCountPromoPosts(userId), HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/list")
    public ResponseEntity<ResListPromoPostDTO> getListPromoPosts(@RequestParam int userId) {
        return new ResponseEntity<>(productsService.getListPromoPosts(userId), HttpStatus.OK);
    }
}
