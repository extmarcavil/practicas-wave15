package com.meli.blog.controller;

import com.meli.blog.dto.BlogDto;
import com.meli.blog.dto.SuccessDto;
import com.meli.blog.model.Blog;
import com.meli.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("blog")
    public ResponseEntity<SuccessDto> saveBlog(@RequestBody Blog blog) {
        return blogService.create(blog);
    }

    @GetMapping("blog/{id}")
    public BlogDto getBlog(@PathVariable Long id) {
        return blogService.findById(id);
    }

    @GetMapping("blogs")
    public List<BlogDto> getAll() {
        return blogService.findAll();
    }

}
