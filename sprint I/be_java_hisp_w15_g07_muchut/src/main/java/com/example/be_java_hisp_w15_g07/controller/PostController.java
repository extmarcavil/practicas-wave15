package com.example.be_java_hisp_w15_g07.controller;


import com.example.be_java_hisp_w15_g07.dto.response.PromoPostsDTO;
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


/**
 *   post controller
 *
 */ /**
 *  post controller
 *
 */
@RestController
@RequestMapping("/products")
public class PostController {

    private IPostService postService;

    public PostController(IPostService postService){
        this.postService = postService;
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<UserFollowedPostsDTO> getUserFollowedPosts (@PathVariable Integer userId, @RequestParam(defaultValue = "date_asc") String order) {
        return new ResponseEntity<>(postService.getFollowedPosts(userId, order), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<?> newPost(@RequestBody NewPostDTO postDTO){
        postService.newPost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);

    }


    /**
     * New post with promo/discount
     *
     * @param body NewPostDTO
     * @return {@link ResponseEntity}
     * @author  Sebastián Muchut
     */
    @PostMapping("/promo-post")
    public ResponseEntity<?> newPostWithPromo (@RequestBody NewPostDTO body) {
        postService.newPost(body);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * get promo products
     *
     * @param userId Integer
     * @return {@link ResponseEntity}
     * @see ResponseEntity
     * @see PromoPostsDTO
     * @author Sebastián Muchut
     */
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostsDTO> getPromoProducts (@RequestParam Integer userId){
        return new ResponseEntity<>(postService.getPromoProducts(userId), HttpStatus.OK);
    }
}
