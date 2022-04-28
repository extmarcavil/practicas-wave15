package com.bootcamp.be_java_hisp_w15_g02.controller;

import com.bootcamp.be_java_hisp_w15_g02.dto.request.PostCreatePromoDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersCountDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetPostCountDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetPostPromoSellerDTO;
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
            return ResponseEntity.status(HttpStatus.OK).body("create post");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<GetPostsSellerByUserIdDTO> getListPostByFollowIdUser(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(this.postService.getListPostByFollowIdUser(userId, order), HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<String> createPost(@RequestBody PostCreatePromoDTO newPost) {
        if (postService.createPostPromo(newPost))
            return ResponseEntity.status(HttpStatus.OK).body("created post with promo");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<GetPostCountDTO> getFollowersCountById(@RequestParam int userId) {
        return new ResponseEntity<>(postService.getPostCountUser(userId), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<GetPostPromoSellerDTO> getListPostByFollowIdUser(@RequestParam int userId) {
        return new ResponseEntity<>(postService.getListPostPromoSeller(userId), HttpStatus.OK);
    }
}
