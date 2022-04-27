package com.sprint.be_java_hisp_w15_g10.Controller;


import com.sprint.be_java_hisp_w15_g10.DTO.Response.UnfollowUserDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.UserDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.UserWithFollowersCountDTO;
import com.sprint.be_java_hisp_w15_g10.Service.IUserService;
import com.sprint.be_java_hisp_w15_g10.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("users/")
@RestController
public class UserController {

    IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("{userId}/followers/count")
    public ResponseEntity<UserWithFollowersCountDTO> getUserWitFollowersCount(@PathVariable int userId){
        return new ResponseEntity<UserWithFollowersCountDTO>(userService.getUsersWithFollowersCount(userId), HttpStatus.OK);
    }

    @PostMapping("{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<UnfollowUserDTO> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow){
        return new ResponseEntity<UnfollowUserDTO>(userService.unfollowUser(userId, userIdToUnfollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public List<UserDTO> getUserFollowers(@PathVariable int userId){


        return null;
    }


    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity followUser(@PathVariable int userId){
        return   null;
    }

}
