package com.sprint.be_java_hisp_w15_g10.Controller;

import com.sprint.be_java_hisp_w15_g10.DTO.Request.PostCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Request.UserCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.*;
import com.sprint.be_java_hisp_w15_g10.Service.IUserService;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.UserWithFollowedUsersDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("users/")
@RestController
public class UserController {

    private final IUserService userService;

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
    public ResponseEntity<FollowersDTO> getUserFollowers(@PathVariable int userId, @RequestParam(defaultValue = "name_asc") String order){

        return new ResponseEntity<FollowersDTO>(userService.getFollowers(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<FollowUserDTO> followUser(@PathVariable int userId, @PathVariable int userIdToFollow){
        return   new ResponseEntity<FollowUserDTO>(userService.followUser(userId, userIdToFollow),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserWithFollowedUsersDTO> getVendorsFollow(@PathVariable int userId, @RequestParam(defaultValue = "name_asc") String order) {
        return new ResponseEntity<>(userService.getUsersWithFollowers(userId, order), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<UserCreatedDTO> createUser(@Valid @RequestBody UserCreateDTO userCreateDTO){
        return new ResponseEntity<>(userService.createUser(userCreateDTO), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getAllUsers(@RequestParam(defaultValue = "name_asc") String order) {
        return new ResponseEntity<>(userService.getAll(order), HttpStatus.OK);
    }

}
