package com.example.be_java_hisp_w15_g07.controller;

import com.example.be_java_hisp_w15_g07.dto.FollowersCountDTO;
import com.example.be_java_hisp_w15_g07.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/users")
public class UserController {

    private IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<Integer> redirect(@PathVariable String userId){

        FollowersCountDTO followers = userService.followersCount(Integer.parseInt(userId));
        return new ResponseEntity<>(followers.getCount(), HttpStatus.OK);


    }

}
