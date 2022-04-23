package com.example.blog.controller;

import com.example.blog.dto.request.BlogEntryRequestDTO;
import com.example.blog.dto.response.BlogEntryInfoDTO;
import com.example.blog.dto.response.CreateEntryResponseDTO;
import com.example.blog.service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    private final IBlogService service;

    public BlogController(IBlogService service) {
        this.service = service;
    }

    @PostMapping("/blog")
    public ResponseEntity<CreateEntryResponseDTO> createEntry(@RequestBody BlogEntryRequestDTO entry){
        return new ResponseEntity<>(service.createEntry(entry), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogEntryInfoDTO> getEntry(@PathVariable int id){
        return new ResponseEntity<>(service.getEntry(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogEntryInfoDTO>> getEntries(){
        return new ResponseEntity<>(service.getEntries(), HttpStatus.OK);
    }
}
