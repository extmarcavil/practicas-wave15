package com.bootcamp.be_java_hisp_w15_g02.controller;

import com.bootcamp.be_java_hisp_w15_g02.dto.request.DiscountedPostCreateDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.DiscountedProductsBySellerDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.DiscountedProductsListDTO;
import com.bootcamp.be_java_hisp_w15_g02.service.IPostService;
import com.bootcamp.be_java_hisp_w15_g02.dto.request.PostCreateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetPostsSellerByUserIdDTO;

@RestController
@RequestMapping("/products")
public class PostController {
    private IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<String> createPost(@RequestBody PostCreateDTO newPost) {
        if (postService.createPost(newPost))
            return ResponseEntity.status(HttpStatus.OK).body("");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<GetPostsSellerByUserIdDTO> getListPostByFollowIdUser(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(this.postService.getListPostByFollowIdUser(userId, order), HttpStatus.OK);
    }

    @PostMapping("promo-post")
    public ResponseEntity<String> createDiscountedProduct(@RequestBody DiscountedPostCreateDTO newPost) {
        if (postService.createPost(newPost))
            return ResponseEntity.status(HttpStatus.OK).body("Publicacion creada exitosamente");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creando la publicacion");
    }

    @GetMapping("promo-post/count")
    public ResponseEntity<DiscountedProductsBySellerDTO> getCountDiscountedProducts(@RequestParam("user_id") int userId) {
        return ResponseEntity.ok(postService.getCountDiscountedProducts(userId));
    }

    @GetMapping("promo-post/list")
    public ResponseEntity<DiscountedProductsListDTO> findDiscountedProductsBySeller(@RequestParam("user_id") int userId) {
        return ResponseEntity.ok(postService.findDiscountedProductsBySeller(userId));
    }
}
