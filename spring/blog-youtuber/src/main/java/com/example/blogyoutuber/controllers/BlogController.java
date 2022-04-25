package com.example.blogyoutuber.controllers;

import com.example.blogyoutuber.models.Blog;
import com.example.blogyoutuber.services.BlogServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    private BlogServiceImpl blogService;

    public BlogController(BlogServiceImpl blogService) {
        this.blogService = blogService;
    }

    //consulta postman: http://localhost:8080/blog
    /* Cuerpo JSON erroneo por ID repetido
    {
        "id": 2,
            "titulo": "Primer articulo",
            "autor": "Pablo Perez",
            "fechaPublicacion": "2022-04-24"
    }

    correcto, sin ID repetido
    {
        "id": 3,
            "titulo": "Primer articulo",
            "autor": "Pablo Perez",
            "fechaPublicacion": "2022-04-24"
    }
     */
    @PostMapping("/blog")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog){
        return new ResponseEntity<>(blogService.save(blog), HttpStatus.OK);
    }

    //consulta postman: http://localhost:8080/blogs
    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> blogAll(){
        return new ResponseEntity<>(blogService.getAll(), HttpStatus.OK);
    }

    //consulta postman: http://localhost:8080/blogs
    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> blogById(@PathVariable Integer id){
        return new ResponseEntity<>(blogService.getBlog(id), HttpStatus.OK);
    }


}
