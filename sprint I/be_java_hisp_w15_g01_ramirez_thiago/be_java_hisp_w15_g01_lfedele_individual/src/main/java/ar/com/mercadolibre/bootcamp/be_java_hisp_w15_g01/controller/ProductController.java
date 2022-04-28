package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.controller;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.*;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service.PostService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private PostService service;

    public ProductController(PostService service) {
        this.service = service;
    }

    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> create(@RequestBody PostDTO postDTO) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.createPost(postDTO));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<ResponseDTO> createPromo(@RequestBody PostPromoDTO dto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.createPostPromo(dto));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoProductCountDTO> getPromoProducsAmountOfUser(@RequestParam Long user_id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getUserPromoPosts(user_id));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListDTO> create(@PathVariable Long userId, @RequestParam(required = false) String order) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getPostsByFollowedUsers(userId, order));
    }


}
