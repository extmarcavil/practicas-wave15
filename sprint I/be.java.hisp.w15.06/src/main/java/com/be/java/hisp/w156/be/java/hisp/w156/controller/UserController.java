package com.be.java.hisp.w156.be.java.hisp.w156.controller;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.UserCountFollowersDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.UserFollowedDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.UserFollowersDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserCountFollowersDTO> getCountFollow(@PathVariable Integer userId){
        UserCountFollowersDTO userCountFollowersDTO = userService.getCountFollowers(userId);
        return new ResponseEntity<>(userCountFollowersDTO, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowersDTO> getFollowers(@PathVariable Integer userId, @RequestParam(required=false) String order){
        UserFollowersDTO userFollowersDTO = userService.getFollowers(userId, order);
        return new ResponseEntity<>(userFollowersDTO, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedDTO> getFollowed(@PathVariable Integer userId, @RequestParam(required=false) String order){
        UserFollowedDTO userFollowedDTO = userService.getFollowed(userId, order);
        return new ResponseEntity<>(userFollowedDTO, HttpStatus.OK);
    }
}
