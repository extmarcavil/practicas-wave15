package com.sprint1.be_java_hisp_w15_g4.controller;

import com.sprint1.be_java_hisp_w15_g4.dto.response.*;
import com.sprint1.be_java_hisp_w15_g4.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping("users/{userId}")
public class UserController {
    IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }

    ////////////////////US0001////////////////////
    @PostMapping("/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable int userId, @PathVariable int userIdToFollow) {
        service.follow(userId, userIdToFollow);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    ////////////////////US0002////////////////////
    //Lucas - Luciano
    @GetMapping("/followers/count")
    public ResponseEntity<FollowerCountDTO> cantidadDeSeguidores(@PathVariable int userId) {
        return new ResponseEntity<>(service.countFollowers(userId), HttpStatus.OK);
    }

    ////////////////////US0003 - US0008////////////////////
    //Lucas - Luciano
    @GetMapping("/followers/list")
    public ResponseEntity<FollowerListDTO> listarSeguidos(@PathVariable int userId, @RequestParam(required = false) String order){
        return new ResponseEntity<>(service.listFollowers(userId,order),HttpStatus.OK);
    }

    ////////////////////US0004////////////////////
    //Nico - Nico
    @GetMapping("/followed/list")
    public ResponseEntity<FollowingListDTO> getFollowingList(@PathVariable int userId, @RequestParam(required = false) String order) {
        return ResponseEntity.status(HttpStatus.OK).body(service.listFollowing(userId, order));
    }

    ////////////////////US0007////////////////////
    //Yamil - Nacho
    @PostMapping("/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfolow(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        service.unfollow(userId, userIdToUnfollow);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
