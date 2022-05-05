package com.bootcamp.be_java_hisp_w15_g08.controller;

import com.bootcamp.be_java_hisp_w15_g08.dto.request.NewPostDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.FollowersCountDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.FollowersListDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.PostListDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.PostNotUserIdDTO;
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

        FollowersListDTO followersListDTO = service.getFollowersList(userId, order);
        return new ResponseEntity<>(followersListDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<FollowersListDTO> getFollowedList(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        FollowersListDTO followedListDTO = service.getFollowedList(userId, order);
        return new ResponseEntity<>(followedListDTO, HttpStatus.ACCEPTED);
    }


    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unFollowUser(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        service.unFollowUser(userIdToUnfollow, userId);
        return ResponseEntity.ok().body("");
    }

//Productos


}
