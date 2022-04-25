package com.bootcamp.Blog.controller;

import com.bootcamp.Blog.dto.EntradaBlogDTO;
import com.bootcamp.Blog.service.IEntradaBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntradaBlogController {

    private final IEntradaBlogService service;

    public EntradaBlogController(IEntradaBlogService service){this.service = service;}

    //post entrada del blog
    @PostMapping("/blog")
    public String postBlogEntry(@RequestBody EntradaBlogDTO entradaBlogDTO){return service.postBlogEntry(entradaBlogDTO);}

    //obtener el blog con el id
    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDTO> getBlogEntryByName(@PathVariable Integer id){
        return new ResponseEntity<>(service.getBlogEntriesByNameDTO(id),HttpStatus.OK);}

    //obtener todos los blogs
    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogDTO>> getAllBlogEntries(){
        return new ResponseEntity<>(service.getAllBlogEntriesDTO(), HttpStatus.OK);}
}
