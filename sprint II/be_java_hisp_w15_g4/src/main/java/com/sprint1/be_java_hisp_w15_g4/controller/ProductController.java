package com.sprint1.be_java_hisp_w15_g4.controller;

import com.sprint1.be_java_hisp_w15_g4.dto.request.PostDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.PostListDTO;
import com.sprint1.be_java_hisp_w15_g4.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    IProductService service;

    public ProductController(IProductService service) {
        this.service = service;
    }
    ////////////////////US0005////////////////////
    //Nico - Nico
    @PostMapping("/post")
    public ResponseEntity<?> postProduct(@RequestBody PostDTO post){
        service.createPost(post);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    ////////////////////US0006////////////////////
    //Yamil - Nacho
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListDTO> lastPosts(@PathVariable int userId, @RequestParam(required = false) String order) {
        return ResponseEntity.ok(service.lastTwoWeeksPosts(userId, order));
    }
}
