package com.sprint1.be_java_hisp_w15_g4.controller;

import com.sprint1.be_java_hisp_w15_g4.dto.request.PostDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.request.PromoPostDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.*;
import com.sprint1.be_java_hisp_w15_g4.service.ISocialMeliService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    //Lucas - Luciano
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<FollowerCountDTO> cantidadDeSeguidores(@PathVariable int userId) {
        return new ResponseEntity<>(service.countFollowers(userId), HttpStatus.OK);
    }

    ////////////////////US0003 - US0008////////////////////
    //Lucas - Luciano
    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<FollowerListDTO> listarSeguidos(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(service.listFollowers(userId, order), HttpStatus.OK);
    }

    ////////////////////US0004////////////////////
    //Nico - Nico
    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<FollowingListDTO> getFollowingList(@PathVariable int userId, @RequestParam(required = false) String order) {
        return ResponseEntity.status(HttpStatus.OK).body(service.listFollowing(userId, order));
    }

    ////////////////////US0005////////////////////
    //Nico - Nico
    @PostMapping("/products/post")
    public ResponseEntity<?> postProduct(@RequestBody PostDTO post) {
        service.createPost(post);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    ////////////////////US0006////////////////////
    //Yamil - Nacho
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<PostListDTO> lastPosts(@PathVariable int userId, @RequestParam(required = false) String order) {
        return ResponseEntity.ok(service.lastTwoWeeksPosts(userId, order));
    }

    ////////////////////US0007////////////////////
    //Yamil - Nacho
    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        service.unfollow(userId, userIdToUnfollow);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    ////////////////////US0010////////////////////
    //Nacho
    @PostMapping("/products/promo-post")
    public ResponseEntity<?> promoPost(@RequestBody PromoPostDTO post) {
        service.createPromoPost(post);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    ////////////////////US0011////////////////////
    //Nacho
    @GetMapping("/products/promo-post/count")
    public ResponseEntity<PromoCountDTO> promoCount(@RequestParam int user_id) {
        return ResponseEntity.ok(service.getPromoCount(user_id));
    }

    ////////////////////US0012////////////////////
    //Nacho
    @GetMapping("/products/promo-post/list")
    public ResponseEntity<PromoListDTO> listPromo(@RequestParam int user_id) {
        return ResponseEntity.ok(service.getPromoList(user_id));
    }
}
