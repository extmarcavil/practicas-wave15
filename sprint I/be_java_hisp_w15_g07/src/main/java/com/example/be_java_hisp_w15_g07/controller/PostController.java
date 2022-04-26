package com.example.be_java_hisp_w15_g07.controller;

import com.example.be_java_hisp_w15_g07.service.IPostService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class PostController {

    private IPostService postService;

    public PostController(IPostService postService){
        this.postService = postService;
    }
}
