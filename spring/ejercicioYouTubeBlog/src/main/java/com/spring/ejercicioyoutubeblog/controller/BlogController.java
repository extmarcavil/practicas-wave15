package com.spring.ejercicioyoutubeblog.controller;

import com.spring.ejercicioyoutubeblog.dto.EntradaBlogDTO;
import com.spring.ejercicioyoutubeblog.service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    private final IBlogService blogService;

    public BlogController(IBlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<Integer> crearEntradaBlog(@RequestBody EntradaBlogDTO entradaBlog) {

        return new ResponseEntity<>(blogService.crearEntradaBlog(entradaBlog), HttpStatus.OK);
    }
}
