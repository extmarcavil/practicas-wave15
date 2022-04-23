package com.example.blogyoutuber.controllers;

import com.example.blogyoutuber.models.Blog;
import com.example.blogyoutuber.services.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/allBlogs")
    public ResponseEntity<List<Blog>> allBlogs(){
        return new ResponseEntity<>(blogService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity <Blog> getBlogById(@PathVariable Integer id){
        return new ResponseEntity<>(blogService.getBlog(id), HttpStatus.OK);
    }

    @PostMapping("/blogs")
    public ResponseEntity<Blog> addBlog(@RequestBody Blog blog){
        return new ResponseEntity<>(blogService.save(blog), HttpStatus.OK);
    }
}
