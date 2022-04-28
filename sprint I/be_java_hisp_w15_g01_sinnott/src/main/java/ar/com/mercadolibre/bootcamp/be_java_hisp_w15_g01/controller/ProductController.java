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
     * ProductController
     * Crea una publicacion
     *
     * @param postDTO el dto de la publicacion a crear
     */
    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> createPost(@RequestBody PostDTO postDTO) {
        log.info("Creating post");
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
    public ResponseEntity<PostListDTO> getPostByFollowedSellers(@PathVariable Long userId, @RequestParam(required = false) String order) {
        log.info("Getting posts by followed sellers");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getPostsByFollowedUsers(userId, order));
    }
    /**
     * ProductController
     * Publica un producto en promocion
     *
     * @param promoPostDTO el dto de la publicacion a crear
     */
    @PostMapping("/promo-post")
    public ResponseEntity<ResponseDTO> createPromoPost(@RequestBody PromoPostDTO promoPostDTO) {
        log.info("Creating promo post");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.createPromoPost(promoPostDTO));
    }

    /**
     * ProductController
     * Obtener la cantidad de productos en promoción de un determinado vendedor
     *
     * @param user_id id del vendedor a buscar
     */
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountDTO> getPromoPostCountById(@RequestParam Long user_id) {
        log.info("Getting promo post count");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.howManyPromoPostById(user_id));
    }

    /**
     * ProductController
     * Actualiza una publicacion
     *
     * @param postDTO el dto de la publicacion a actualizar
     */
    @PutMapping("/update/{postId}")
    public ResponseEntity<ResponseDTO> updatePost(@PathVariable Long postId, @RequestBody PromoPostDTO postDTO) {
        log.info("Updating post");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.updatePost(postId, postDTO));
    }

    /**
     * ProductController
     * Obtiene los productos de un determinado vendedor
     *
     * @param userId id del vendedor a buscar
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<PostListDetailDTO> getAllPostsByUserId(@PathVariable Long userId) {
        log.info("Getting all posts by user id");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getAllPostsByUserId(userId));
    }
}
