package com.sprint1.be_java_hisp_w15_g4.controller;

import com.sprint1.be_java_hisp_w15_g4.dto.response.FollowerCountDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.FollowerListDTO;
import com.sprint1.be_java_hisp_w15_g4.service.ISocialMeliService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<FollowerCountDTO> cantidadDeSeguidores(@PathVariable int userId){
        return new ResponseEntity<>(service.countFollowers(userId),HttpStatus.OK);
    }

    ////////////////////US0003////////////////////
    //Lucas - Luciano
        @GetMapping("/users/{userId}/followers/list")
        public ResponseEntity<FollowerListDTO> listarSeguidos(@PathVariable int userId){
            return new ResponseEntity<>(service.listFollowers(userId),HttpStatus.OK);
        }


    ////////////////////US0004////////////////////
    //Nico - Nico

    ////////////////////US0005////////////////////
    //Nico - Nico

    ////////////////////US0006////////////////////
    //Yamil - Nacho

    ////////////////////US0007////////////////////
    //Yamil - Nacho

}
