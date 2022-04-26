package com.sprint1.be_java_hisp_w15_g4.controller;

import com.sprint1.be_java_hisp_w15_g4.dto.response.PostListDTO;
import com.sprint1.be_java_hisp_w15_g4.service.ISocialMeliService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MeliController {
    ISocialMeliService service;

    public MeliController(ISocialMeliService service) {
        this.service = service;
    }

    ////////////////////US0001////////////////////
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable int userId, @PathVariable int userIdToFollow){
        service.follow(userId, userIdToFollow);
        return ResponseEntity.status(HttpStatus.OK).build();
    }



    ////////////////////US0002////////////////////
    //Lucas - Luciano

    ////////////////////US0003////////////////////
    //Lucas - Luciano

    ////////////////////US0004////////////////////
    //Nico - Nico

    ////////////////////US0005////////////////////
    //Nico - Nico

    ////////////////////US0006////////////////////
    //Yamil - Nacho
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<PostListDTO> lastPosts (@PathVariable int userId) {
        return ResponseEntity.ok(service.lastTwoWeeksPosts(userId));
    }

    ////////////////////US0007////////////////////
    //Yamil - Nacho

}
