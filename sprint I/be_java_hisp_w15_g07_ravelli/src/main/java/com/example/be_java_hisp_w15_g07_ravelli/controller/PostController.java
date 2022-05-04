package com.example.be_java_hisp_w15_g07_ravelli.controller;


import com.example.be_java_hisp_w15_g07_ravelli.dto.response.PromoProductsCountDTO;
import com.example.be_java_hisp_w15_g07_ravelli.dto.response.UserFollowedPostsDTO;
import com.example.be_java_hisp_w15_g07_ravelli.dto.response.UserPromoPosts;
import com.example.be_java_hisp_w15_g07_ravelli.service.IPostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.be_java_hisp_w15_g07_ravelli.dto.request.NewPostDTO;
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
     * returns a List of products for one of the users followed
     *
     * @param userId Integer
     * @return {@link ResponseEntity}
     * @see ResponseEntity
     * @author Jeronimo Graff
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<UserFollowedPostsDTO> getUserFollowedPosts (@PathVariable Integer userId, @RequestParam(defaultValue = "date_asc") String order) {
        return new ResponseEntity<>(postService.getFollowedPosts(userId, order), HttpStatus.OK);
    }

    /**
     * add new user post
     *
     * @return {@link ResponseEntity}
     * @see ResponseEntity
     * @author Jeronimo Graff
     */
    @PostMapping("/post")
    public ResponseEntity<?> newPost(@RequestBody NewPostDTO postDTO){
        postService.newPost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * new post with discount
     *
     * @param postDTO {@link NewPostDTO}
     * @return {@link ResponseEntity}
     * @see ResponseEntity
     * @author Tomas Ravelli
     */
    @PostMapping("/promo-post")
    public ResponseEntity<?> newPromoPost(@RequestBody NewPostDTO postDTO){
        postService.newPromoPost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * get count of promo products by user id
     *
     * @param userId Integer
     * @return {@link ResponseEntity}
     * @see ResponseEntity
     * @see PromoProductsCountDTO
     */
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoProductsCountDTO> getPromoPostCount (@RequestParam(name = "user_id") Integer userId) {
        return new ResponseEntity<>(postService.getPromoProductsCountByUserId(userId), HttpStatus.OK);
    }

    /**
     * get promo posts by user id
     *
     * @param userId Integer
     * @return {@link ResponseEntity}
     * @see ResponseEntity
     * @see UserPromoPosts
     */
    @GetMapping("/promo-post/list")
    public ResponseEntity<UserPromoPosts> getPromoPosts (@RequestParam(name = "user_id") Integer userId) {
        return new ResponseEntity<>(postService.getPromoPosts(userId), HttpStatus.OK);
    }
}
