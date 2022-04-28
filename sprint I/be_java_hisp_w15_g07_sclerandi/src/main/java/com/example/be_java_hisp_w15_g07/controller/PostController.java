package com.example.be_java_hisp_w15_g07.controller;

import com.example.be_java_hisp_w15_g07.dto.request.NewPromoPostDTO;
import com.example.be_java_hisp_w15_g07.dto.response.PromoPostsListDTO;
import com.example.be_java_hisp_w15_g07.dto.response.PromoProductsCountDTO;
import com.example.be_java_hisp_w15_g07.dto.response.UserFollowedPostsDTO;
import com.example.be_java_hisp_w15_g07.service.IPostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.be_java_hisp_w15_g07.dto.request.NewPostDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {

    private IPostService postService;

    public PostController(IPostService postService){
        this.postService = postService;
    }

    /**
     * Get user followed posts
     *
     * @param userId Integer
     * @param order String
     * @return {@link ResponseEntity}
     * @see ResponseEntity
     * @see UserFollowedPostsDTO
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<UserFollowedPostsDTO> getUserFollowedPosts (
            @PathVariable Integer userId,
            @RequestParam(defaultValue = "date_asc") String order) {
        return new ResponseEntity<>(postService.getFollowedPosts(userId, order), HttpStatus.OK);
    }

    /**
     * Create new post
     *
     * @param postDTO {@link NewPostDTO}
     * @return {@link ResponseEntity}
     * @see ResponseEntity
     */
    @PostMapping("/post")
    public ResponseEntity<?> newPost(@RequestBody NewPostDTO postDTO){
        postService.newPost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create new promo post
     *
     * @param postDTO {@link NewPromoPostDTO}
     * @return {@link ResponseEntity}
     * @see ResponseEntity
     */
    @PostMapping("/promo-post")
    public ResponseEntity<?> newPromoPost(@RequestBody NewPromoPostDTO postDTO){
        postService.newPromoPost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Get promo products count
     *
     * @param userId Integer
     * @return {@link ResponseEntity}
     * @see ResponseEntity
     * @see PromoProductsCountDTO
     */
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoProductsCountDTO> getPromoProductsCount(@RequestParam(name="user_id") Integer userId){
        return new ResponseEntity<>(postService.getPromoProductsCount(userId), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoPostsListDTO> getPromoProductsList(@RequestParam(name="user_id") Integer userId){
        return new ResponseEntity<>(postService.getPromoProductsList(userId), HttpStatus.OK);
    }
}
