package com.blog.Blog.controller;

import com.blog.Blog.dto.BlogDTO;
import com.blog.Blog.service.BlogServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    BlogServiceInterface service;

    public BlogController(BlogServiceInterface service) {
        this.service = service;
    }

    @PostMapping("/blog")
    public ResponseEntity<String> agregarBlog(@RequestBody BlogDTO blog) {
        service.agregarBlog(blog);
        return new ResponseEntity<>("Se ha agregado la entrada con exito", HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public  ResponseEntity<BlogDTO> getBlog (@PathVariable int id ) {
        BlogDTO blog = service.getEntrada(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public  ResponseEntity<List<BlogDTO>> getBlogs () {
        List<BlogDTO> blog = service.obtenerEntradas();
        if(blog.size() > 0) {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
