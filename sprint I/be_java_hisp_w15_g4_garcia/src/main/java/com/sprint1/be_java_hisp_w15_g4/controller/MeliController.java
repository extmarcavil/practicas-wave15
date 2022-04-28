package com.sprint1.be_java_hisp_w15_g4.controller;

import com.sprint1.be_java_hisp_w15_g4.dto.request.PostDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.request.PostWithPromoDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.*;
import com.sprint1.be_java_hisp_w15_g4.service.ISocialMeliService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MeliController {
    ISocialMeliService service;

    public MeliController(ISocialMeliService service) {
        this.service = service;
    }

    ////////////////////US0001////////////////////
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable int userId, @PathVariable int userIdToFollow) {
        service.follow(userId, userIdToFollow);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    ////////////////////US0002////////////////////
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<FollowerCountDTO> cantidadDeSeguidores(@PathVariable int userId) {
        return new ResponseEntity<>(service.countFollowers(userId), HttpStatus.OK);
    }

    ////////////////////US0003 - US0008////////////////////
        @GetMapping("/users/{userId}/followers/list")
        public ResponseEntity<FollowerListDTO> listarSeguidos(@PathVariable int userId, @RequestParam(required = false) String order){
            return new ResponseEntity<>(service.listFollowers(userId,order),HttpStatus.OK);
        }


    ////////////////////US0004////////////////////
    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<FollowingListDTO> getFollowingList(@PathVariable int userId, @RequestParam(required = false) String order) {
        return ResponseEntity.status(HttpStatus.OK).body(service.listFollowing(userId, order));
    }

    ////////////////////US0005////////////////////
    @PostMapping("/products/post")
    public ResponseEntity<?> postProduct(@RequestBody PostDTO post){
        service.createPost(post);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    ////////////////////US0006////////////////////
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<PostListDTO> lastPosts(@PathVariable int userId, @RequestParam(required = false) String order) {
        return ResponseEntity.ok(service.lastTwoWeeksPosts(userId, order));
    }

    ////////////////////US0007////////////////////
    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> lastPosts(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        service.unfollow(userId, userIdToUnfollow);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    ////////////////////US0010////////////////////
    @PostMapping("/products/promo-post")
    public ResponseEntity<?> postWithPromo(@RequestBody PostWithPromoDTO promo){
        service.createPostWithPromo(promo);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    ////////////////////US0011////////////////////
    @GetMapping("/products/promo-post/count")
    public ResponseEntity<DiscountCountDTO> countDiscounts(@RequestParam int user_id) {
        return new ResponseEntity<>(service.countDiscountPost(user_id), HttpStatus.OK);
    }

    ////////////////////US0012////////////////////
    @GetMapping("/products/promo-post/list")
    public ResponseEntity<DiscountListDTO> discountProductsList(@RequestParam int user_id){
        return ResponseEntity.status(HttpStatus.OK).body(service.listDiscountProducts(user_id));
    }

}
