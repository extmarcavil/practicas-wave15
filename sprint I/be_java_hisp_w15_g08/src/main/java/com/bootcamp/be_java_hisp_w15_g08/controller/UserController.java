package com.bootcamp.be_java_hisp_w15_g08.controller;

import com.bootcamp.be_java_hisp_w15_g08.dto.response.FollowersCountDTO;
import com.bootcamp.be_java_hisp_w15_g08.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow ){
            service.followUser(userIdToFollow,userId);
            return ResponseEntity.ok().body("");
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> followersCount(@PathVariable Integer userId ){
        FollowersCountDTO followersCountDTO = service.countFollers(userId);
        return new ResponseEntity<>(followersCountDTO, HttpStatus.ACCEPTED);
    }
    



}
