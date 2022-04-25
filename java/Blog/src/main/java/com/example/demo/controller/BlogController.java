package com.example.demo.controller;

import com.example.demo.dto.BlogDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    @GetMapping(path = "/blog")
    public ResponseEntity<BlogDTO> getId(){

    }
}
