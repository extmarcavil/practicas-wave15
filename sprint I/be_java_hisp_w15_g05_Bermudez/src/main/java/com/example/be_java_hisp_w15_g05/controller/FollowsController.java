package com.example.be_java_hisp_w15_g05.controller;

import com.example.be_java_hisp_w15_g05.service.IFollowsService;
import com.example.be_java_hisp_w15_g05.dto.response.ResCountFollowersDTO;
import com.example.be_java_hisp_w15_g05.dto.response.ResListFollowersDTO;
import com.example.be_java_hisp_w15_g05.dto.response.ResListSellersDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FollowsController {
    private IFollowsService userService;

    public FollowsController(IFollowsService userService) {

        this.userService = userService;
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity follow(@PathVariable int userId, @PathVariable int userIdToFollow) {

        return new ResponseEntity<>(userService.follow(userId, userIdToFollow), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity unFollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) {

        return new ResponseEntity<>(userService.unFollow(userId, userIdToUnfollow), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<ResCountFollowersDTO> countFollowers(@PathVariable int userId) {

        return new ResponseEntity<>(userService.countFollowers(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<ResListFollowersDTO> getListFollowers(@PathVariable int userId,@RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getListFollowers(userId, order), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<ResListSellersDTO> getListFollowed(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getListSellers(userId, order), HttpStatus.OK);
    }

}
