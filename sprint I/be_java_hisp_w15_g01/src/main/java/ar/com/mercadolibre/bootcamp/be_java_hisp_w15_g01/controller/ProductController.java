package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.controller;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.PostDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.PostListDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ResponseDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.VendorInfoDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service.PostService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/products")
public class ProductController {

    private PostService service;

    public ProductController(PostService service) {
        this.service = service;
    }

    @PostMapping({"/post", "/promo-post"})
    public ResponseEntity<ResponseDTO> create(@RequestBody PostDTO postDTO) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.createPost(postDTO));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListDTO> create(@PathVariable Long userId, @RequestParam(required = false) String order) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getPostsByFollowedUsers(userId, order));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<VendorInfoDTO> create(@RequestParam(required = true) Long user_id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getPromoPostsCount(user_id));
    }


}
