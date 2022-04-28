package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.controller;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.*;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service.PostService;

import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Log
public class ProductController {

    private final PostService service;

    public ProductController(PostService service) {
        this.service = service;
    }

    /**
     * Endpoint US 05
     * Dar de alta una publicacion
     */
    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> createPost(@RequestBody PostDTO postDTO) {
        log.info("Creating post");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.createPost(postDTO));
    }

    /**
     * Endpoint US 06 y 09
     * Obtener un listado de las publicaciones realizadas por los
     * vendedores que un usuario sigue en las últimas dos semanas
     * Ordenamiento por fecha ascendente y descendente
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListDTO> getPostByFollowedSellers(@PathVariable Long userId, @RequestParam(required = false) String order) {
        log.info("Getting posts by followed sellers");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getPostsByFollowedUsers(userId, order));
    }

    /**
     * Endpoint US 10
     * Llevar a cabo la publicación de un nuevo producto en promoción
     */
    @PostMapping("/promo-post")
    public ResponseEntity<ResponseDTO> createPromoPost(@RequestBody PromoPostDTO promoPostDTO) {
        log.info("Creating promo post");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.createPromoPost(promoPostDTO));
    }

    /**
     * Endpoint US 11
     * Obtener la cantidad de productos en promoción de un determinado vendedor
     */
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountDTO> getPromoPostCountById(@RequestParam Long user_id) {
        log.info("Getting promo post count");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.howManyPromoPostById(user_id));
    }

    /**
     * Endpoint US 12
     * Actualizar la información de un post existente
     */
    @PutMapping("/update/{postId}")
    public ResponseEntity<ResponseDTO> updatePost(@PathVariable Long postId, @RequestBody PromoPostDTO postDTO) {
        log.info("Updating post");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.updatePost(postId, postDTO));
    }

    /**
     * Endpoint US 13
     * Obtener un listado de todos los productos de un determinado vendedor
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<PostListDetailDTO> getAllPostsByUserId(@PathVariable Long userId) {
        log.info("Getting all posts by user id");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getAllPostsByUserId(userId));
    }
}
