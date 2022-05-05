package com.example.be_java_hisp_w15_g05.controller;

import com.example.be_java_hisp_w15_g05.dto.PostDTO;
import com.example.be_java_hisp_w15_g05.dto.ResCreatePostDTO;
import com.example.be_java_hisp_w15_g05.dto.ResPostListDTO;
import com.example.be_java_hisp_w15_g05.service.IProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@RestController
@RequestMapping("/products")
public class ProductsController {

    private IProductsService productsService;

    public ProductsController(IProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping("/post")
    public ResponseEntity<ResCreatePostDTO> createPost(@Valid @RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(productsService.createPost(postDTO), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ResPostListDTO> queryPost(
            @Positive(message = FollowsController.userIDPositive)
            @NotNull(message = FollowsController.userIDNotNull)
            @PathVariable int userId,
            @RequestParam(required = false, defaultValue = "") String order) {
        return new ResponseEntity<>(productsService.getPostFollowed(userId, order), HttpStatus.OK);

    }



}
