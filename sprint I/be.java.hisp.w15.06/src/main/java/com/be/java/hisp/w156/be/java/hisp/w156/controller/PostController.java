package com.be.java.hisp.w156.be.java.hisp.w156.controller;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.PostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.service.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class PostController {

    IPostService service;
    public  PostController(IPostService service){
        this.service = service;
    }

    @PostMapping("/post")
    public ResponseEntity<PostDTO> alta(@Valid @RequestBody PostDTO postDTO ){
        return new ResponseEntity<>(service.createPost(postDTO), HttpStatus.OK);
    }


}
