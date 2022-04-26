package com.bootcamp.blog.controller;

import com.bootcamp.blog.model.EntradaBlog;
import com.bootcamp.blog.service.IBlogService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/blog")
public class BlogController {

    private IBlogService iBlogService;

    @GetMapping("/{id}")
    public ResponseEntity<EntradaBlog> buscarPorId(@PathVariable Long id){
        return new ResponseEntity<>(iBlogService.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> crearBlog(@RequestBody EntradaBlog entradaBlog){
        return new ResponseEntity<>(iBlogService.crearBlog(entradaBlog), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EntradaBlog>> buscarTodos(){
        return new ResponseEntity<>(iBlogService.buscarTodos(), HttpStatus.OK);
    }
}
