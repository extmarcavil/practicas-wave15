package com.bootcamp.blog.controller;

import com.bootcamp.blog.dto.EntradaBlogDTO;
import com.bootcamp.blog.model.EntradaBlog;
import com.bootcamp.blog.service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {

    IBlogService service;

    public BlogController(IBlogService service) {
        this.service = service;
    }

    @GetMapping("/blog/{id}/{titulo}/{nombre}/{fecha}")
    public ResponseEntity<EntradaBlogDTO> entrada (@PathVariable Integer id, @PathVariable String titulo, @PathVariable String nombre, @PathVariable String fecha){
            return new ResponseEntity<>(service.makeEntrada(id,titulo,nombre,fecha), HttpStatus.ACCEPTED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDTO> findById (@PathVariable Integer id){
            return new ResponseEntity<>(service.findById(id), HttpStatus.ACCEPTED);

    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlog>> allBlogs (){
        return new ResponseEntity(service.allEntradas(),HttpStatus.FOUND);
    }




}
