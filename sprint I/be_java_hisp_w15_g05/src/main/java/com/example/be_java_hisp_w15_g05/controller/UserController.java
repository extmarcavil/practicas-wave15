package com.example.be_java_hisp_w15_g05.controller;

import com.example.be_java_hisp_w15_g05.dto.ResCountFollowersDTO;
import com.example.be_java_hisp_w15_g05.dto.ResFollowPostDTO;
import com.example.be_java_hisp_w15_g05.dto.ResListFollowersDTO;
import com.example.be_java_hisp_w15_g05.service.IUserService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<ResFollowPostDTO> follow(@PathVariable int userId, @PathVariable int userIdToFollow) {
        ResFollowPostDTO res = userService.follow(userId, userIdToFollow);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<ResCountFollowersDTO> countFollowers(@PathVariable int userId) {
        return new ResponseEntity<>(userService.countFollowers(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<ResListFollowersDTO> getListFollowers(@PathVariable int userId) {
        return new ResponseEntity<>(userService.getListFollowers(userId), HttpStatus.OK);
    }
}
