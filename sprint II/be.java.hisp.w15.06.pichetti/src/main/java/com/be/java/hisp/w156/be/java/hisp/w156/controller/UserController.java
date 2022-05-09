package com.be.java.hisp.w156.be.java.hisp.w156.controller;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.UserCountFollowersDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.UserFollowedDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.UserFollowersDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.SuccessDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<SuccessDTO> follow(@PathVariable @Min(1) Integer userId, @PathVariable @Min(1) Integer userIdToFollow){
        return userService.follow(userId, userIdToFollow);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<SuccessDTO> unfollow(@PathVariable @Min(1) Integer userId, @PathVariable @Min(1) Integer userIdToUnfollow){
        return userService.unfollow(userId,userIdToUnfollow);
    }


    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserCountFollowersDTO> getCountFollow(@PathVariable @Min(1) Integer userId){
        return userService.getCountFollowers(userId);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowersDTO> getFollowers(@PathVariable @Min(1) Integer userId, @RequestParam(required=false, defaultValue = "") String order){
        return userService.getFollowers(userId, order);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedDTO> getFollowed(@PathVariable @Min(1) Integer userId, @RequestParam(required=false, defaultValue = "") String order){
        return userService.getFollowed(userId, order);
    }
}
