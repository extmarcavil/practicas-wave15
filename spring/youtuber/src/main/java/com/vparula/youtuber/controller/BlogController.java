package com.vparula.youtuber.controller;

import com.vparula.youtuber.dto.EntradaDTO;
import com.vparula.youtuber.model.EntradaBlog;
import com.vparula.youtuber.service.IServiceBlog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    IServiceBlog service;

    public BlogController(IServiceBlog service) {
        this.service = service;
    }


    @PostMapping("/blog")
    public ResponseEntity<String> agregarBlog(@RequestBody EntradaBlog blog){
            service.agregarBlog(blog);
            return new ResponseEntity<>("Se ha agregado la entrada con exito", HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public  ResponseEntity<EntradaDTO> getBlog (@PathVariable int id ) {
        EntradaDTO blog = service.getEntrada(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);

    }

    @GetMapping("/blogs")
    public  ResponseEntity<List<EntradaDTO>> getBlogs () {
        List<EntradaDTO> blog = service.obtenerEntradas();
        if(blog.size()>0)
            return new ResponseEntity<>(blog, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

}
