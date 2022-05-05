package com.example.blog.controller;

import com.example.blog.dto.EntradaBlogDTO;
import com.example.blog.model.EntradaBlog;
import com.example.blog.service.EntradaBlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Blogcontroller {
    EntradaBlogService service;

    public Blogcontroller(EntradaBlogService service) {
        this.service = service;
    }

    @PostMapping("/blog")
    public ResponseEntity<Long> saveBlog(@RequestBody EntradaBlogDTO entrada) {
        return ResponseEntity.ok(service.agregarEntrada(entrada));
    }
}
