package com.example.blogapi.controller;

import com.example.blogapi.dto.BlogDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @PostMapping("/")
    public ResponseEntity<String> crearEntradaBlog(@RequestBody BlogDTO nuevaEntrada){
        String mensaje = "";



        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }
}
