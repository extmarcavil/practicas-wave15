package com.youtuber.spring.controller;


import com.youtuber.spring.dto.EntradaBlog;
import com.youtuber.spring.service.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class BlogController {

    @Autowired
    BlogServiceImpl blogService;


    @PostMapping("/blog")
    ResponseEntity<EntradaBlog> createBlog(@RequestBody EntradaBlog entradaBlog){
        System.out.println(entradaBlog.getEntrada());


              return  blogService.crearEntrada(entradaBlog);



    }

    @GetMapping("blogs")
    ResponseEntity <List<EntradaBlog>> getAllBlog(){
        return blogService.getAll();
    }


    @GetMapping("/blog/{id}")
    ResponseEntity<EntradaBlog> getBlog(@PathVariable Integer id){
        return blogService.getBlog(id);
    }



    @GetMapping
    ResponseEntity<EntradaBlog> test(){
        System.out.println("funciona∫");
        return new ResponseEntity<EntradaBlog>((EntradaBlog) null, HttpStatus.OK);
    }
}
