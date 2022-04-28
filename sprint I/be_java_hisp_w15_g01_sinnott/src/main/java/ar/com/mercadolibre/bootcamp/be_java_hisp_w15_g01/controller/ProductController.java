package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.controller;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.*;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service.PostService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final PostService service;

    public ProductController(PostService service) {
        this.service = service;
    }

    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> createPost(@RequestBody PostDTO postDTO) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.createPost(postDTO));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListDTO> getPostByFollowedSellers(@PathVariable Long userId, @RequestParam(required = false) String order) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getPostsByFollowedUsers(userId, order));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<ResponseDTO> createPromoPost(@RequestBody PromoPostDTO promoPostDTO) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.createPromoPost(promoPostDTO));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountDTO> getPromoPostCountById(@RequestParam Long user_id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.howManyPromoPostById(user_id));
    }

    @PutMapping("/update/{postId}")
    public ResponseEntity<ResponseDTO> updatePost(@PathVariable Long postId, @RequestBody PromoPostDTO postDTO) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.updatePost(postId, postDTO));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<PostListDetailDTO> getAllPostsByUserId(@PathVariable Long userId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getAllPostsByUserId(userId));
    }
}
