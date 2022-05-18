package com.example.blog.controller;

import com.example.blog.DTO.BlogDTO;
import com.example.blog.service.IBlogServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    IBlogServices services;

    public BlogController(IBlogServices services) {
        this.services = services;
    }

    @PostMapping("/blog/{title}/{name}")
    public ResponseEntity<Integer> saveNewEntry(@PathVariable String title, @PathVariable String name){
        return new ResponseEntity<>(services.newBlog(title, name), HttpStatus.OK);
    }

    @GetMapping("blog/{id}")
    public ResponseEntity<BlogDTO> getBlogInformation(@PathVariable Integer id){
        return new ResponseEntity<>(services.getBlogInformation(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDTO>> getAllBlogs(){
        return new ResponseEntity<>(services.getAllBlogs(), HttpStatus.OK);
    }


}
