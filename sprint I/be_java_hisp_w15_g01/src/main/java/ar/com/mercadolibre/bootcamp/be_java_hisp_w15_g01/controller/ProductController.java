package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.controller;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.PostDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.PostListDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ResponseDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service.PostService;

import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/products")
@Log
public class ProductController {

    private PostService service;

    public ProductController(PostService service) {
        this.service = service;
    }

    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> create(@RequestBody PostDTO postDTO) {
        log.info("Se recibio peticion de creacion de una publicacion");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.createPost(postDTO));
    }



    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListDTO> followed(@PathVariable Long userId, @RequestParam(required = false) String order) {
        log.info("Se recibio peticion de obtener todos los posts de las personas que sigue el id " + userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getPostsByFollowedUsers(userId, order));
    }

}
