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

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ResPostListDTO> getPostFollowed(@PathVariable int userId, @RequestParam(required = false, defaultValue = "") String order) {
        return new ResponseEntity<>(productsService.getPostFollowed(userId, order), HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<ResCreatePostDTO> createPromoPost(@RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(productsService.createPost(postDTO), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<ResPromoPostsDTO> getCountPromoPosts(@RequestParam int userId) {
        return new ResponseEntity<>(productsService.getCountPromoPosts(userId), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<ResListPromoPostDTO> getListPromoPosts(@RequestParam int userId) {
        return new ResponseEntity<>(productsService.getListPromoPosts(userId), HttpStatus.OK);
    }
}
