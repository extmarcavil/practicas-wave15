package com.bootcamp.be_java_hisp_w15_g02.controller;

import com.bootcamp.be_java_hisp_w15_g02.repository.IPostRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class PostController {
    private IPostRepository postRepository;

    public PostController(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }
}
