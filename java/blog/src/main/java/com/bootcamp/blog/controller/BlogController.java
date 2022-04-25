package com.bootcamp.blog.controller;

import com.bootcamp.blog.dto.BlogDTO;
import com.bootcamp.blog.dto.ResponseBlogDTO;
import com.bootcamp.blog.service.IBlogService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BlogController {

    public IBlogService service;

    public BlogController(IBlogService service) {
        this.service = service;
    }

    @PostMapping("/blog")
    public ResponseBlogDTO
}
