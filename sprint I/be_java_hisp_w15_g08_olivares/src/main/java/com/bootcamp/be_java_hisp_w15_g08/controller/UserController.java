package com.bootcamp.be_java_hisp_w15_g08.controller;

import com.bootcamp.be_java_hisp_w15_g08.dto.request.NewPostDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.request.PromoDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.*;
import com.bootcamp.be_java_hisp_w15_g08.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        service.followUser(userIdToFollow, userId);
        return ResponseEntity.ok().body("");
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> followersCount(@PathVariable Integer userId) {
        FollowersCountDTO followersCountDTO = service.countFollers(userId);
        return new ResponseEntity<>(followersCountDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<FollowersListDTO> getFollowersList(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        if (order != null && !order.equals("name_asc") && !order.equals("name_desc")) {
            throw new IllegalArgumentException("Parametro incorrecto, verificar el parametro ingresado");
        }
        FollowersListDTO followersListDTO = service.getFollowersList(userId, order);
        return new ResponseEntity<>(followersListDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<FollowersListDTO> getFollowedList(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        if (order != null && !order.equals("name_asc") && !order.equals("name_desc")) {
            throw new IllegalArgumentException("Parametro incorrecto, verificar el parametro ingresado");
        }
        FollowersListDTO followedListDTO = service.getFollowedList(userId, order);
        return new ResponseEntity<>(followedListDTO, HttpStatus.ACCEPTED);
    }

    @PostMapping("/products/post")
    public ResponseEntity<PostNotUserIdDTO> createPost(@RequestBody NewPostDTO newPostDTO) {
        PostNotUserIdDTO newPostDTO1 = service.addPost(newPostDTO);
        return new ResponseEntity<>(newPostDTO1, HttpStatus.ACCEPTED);
    }

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<PostListDTO> getSellersLastsPosts(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        if (order != null && !order.equals("date_asc") && !order.equals("date_desc")) {
            throw new IllegalArgumentException("Parametro incorrecto, verificar el parametro ingresado");
        }
        PostListDTO postListDTO = service.getSellersLastsPosts(userId, order);
        return new ResponseEntity<>(postListDTO, HttpStatus.ACCEPTED);
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unFollowUser(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        service.unFollowUser(userIdToUnfollow, userId);
        return ResponseEntity.ok().body("");
    }
    @PostMapping("/products/promo-post")
    public ResponseEntity<?> post(@RequestBody PromoDTO promoDTO) {
        service.addPromo(promoDTO);
        return ResponseEntity.ok().body("");
    }
    @GetMapping("/products/promo-post/count?user_id={userId}")
    public ResponseEntity<PromoCountDTO> getPromoCount(@PathVariable Integer userId) {
        PromoCountDTO promoCountDTO = service.getPromoCount(userId);
        return new ResponseEntity<>(promoCountDTO, HttpStatus.ACCEPTED);
    }
    @GetMapping("/products/promo-post/list?user_id={userId}")
    public ResponseEntity<PromoListDTO> getPromoList(@PathVariable Integer userId) {
        PromoListDTO promoListDTO = service.getPromoList(userId);
        return new ResponseEntity<>(promoListDTO, HttpStatus.ACCEPTED);
    }

}
