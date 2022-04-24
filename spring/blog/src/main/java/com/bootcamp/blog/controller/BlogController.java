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
    public ResponseEntity<String> entrada (@PathVariable Integer id, @PathVariable String titulo, @PathVariable String nombre, @PathVariable String fecha){
        EntradaBlogDTO entradaBlog = service.makeEntrada(id,titulo,nombre,fecha);
        if(entradaBlog.getId() == null) {
            return new ResponseEntity<>("El id ingresado ya existe, intenta con otro id", HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>("Ingreso realizado con exito", HttpStatus.ACCEPTED);
        }
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<String> findById (@PathVariable Integer id){
        EntradaBlogDTO entradaBlog = service.findById(id);
        if(entradaBlog.getAuthorName().equals("")) {
            return new ResponseEntity<>("El id ingresado no existe", HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(entradaBlog.toString(), HttpStatus.ACCEPTED);
        }
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlog>> allBlogs (){
        return new ResponseEntity(service.allEntradas(),HttpStatus.FOUND);
    }




}
