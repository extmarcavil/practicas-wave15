package com.bootcamp.be_java_hisp_w15_g02_sanchez.controller;

import com.bootcamp.be_java_hisp_w15_g02_sanchez.dto.response.GetProductsCountPromoByUserDTO;
import com.bootcamp.be_java_hisp_w15_g02_sanchez.dto.response.GetProductsPromoByUserDTO;
import com.bootcamp.be_java_hisp_w15_g02_sanchez.service.IPostService;
import com.bootcamp.be_java_hisp_w15_g02_sanchez.dto.request.PostCreateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bootcamp.be_java_hisp_w15_g02_sanchez.dto.response.GetPostsSellerByUserIdDTO;

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

    @PostMapping("/post/promo-post")
    public ResponseEntity<String> createPostPromo(@RequestBody PostCreateDTO newPost) {
        if (postService.createPost(newPost))
            return ResponseEntity.status(HttpStatus.OK).body("");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<GetProductsCountPromoByUserDTO> getProductsCountPromoByUser(@RequestParam(required = true,name = "user_id") int userId) {
        return new ResponseEntity<>(this.postService.getProductsCountPromoByUser(userId), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<GetProductsPromoByUserDTO> getProductsPromoByUser(@RequestParam(required = true,name = "user_id") int userId
            ,@RequestParam(required = false,name = "order") String order) {
        return new ResponseEntity<>(this.postService.getProductsPromoByUser(userId,order), HttpStatus.OK);
    }
}
