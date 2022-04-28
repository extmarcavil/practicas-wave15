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


    /**
     * ProductController
     * Crea una publicacion
     *
     * @param postDTO el dto de la publicacion a crear
     */
    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> create(@RequestBody PostDTO postDTO) {
        log.info("Se recibio peticion de creacion de una publicacion");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.createPost(postDTO));
    }

    /**
     * ProductController
     * Devuelve la lista de usuarios que siguen al parametro userId
     *
     * @param userId User a buscar.
     * @param order orden de los resultados.
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListDTO> followed(@PathVariable Long userId, @RequestParam(required = false) String order) {
        log.info("Se recibio peticion de obtener todos los posts de las personas que sigue el id " + userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getPostsByFollowedUsers(userId, order));
    }

}
