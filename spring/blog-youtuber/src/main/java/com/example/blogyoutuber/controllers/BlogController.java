package com.example.blogyoutuber.controllers;

import com.example.blogyoutuber.models.Blog;
import com.example.blogyoutuber.services.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;


    @GetMapping("/allBlogs")
    public List<Blog> allBlogs(){
        return blogService.getAll();
    }

    @GetMapping("blogs/{id}")
    Blog getBlogById(@PathVariable Integer id){
        return (Blog) blogService.getBlog(id);
    }

    @PostMapping("blogs")
    Blog addBlog(@RequestBody Blog blog){
        return blogService.save(blog);
    }
}
