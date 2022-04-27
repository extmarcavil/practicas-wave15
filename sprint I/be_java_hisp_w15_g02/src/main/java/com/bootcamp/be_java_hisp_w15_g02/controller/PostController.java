package com.bootcamp.be_java_hisp_w15_g02.controller;

import com.bootcamp.be_java_hisp_w15_g02.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w15_g02.service.IPostService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class PostController {
    private IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }
}
