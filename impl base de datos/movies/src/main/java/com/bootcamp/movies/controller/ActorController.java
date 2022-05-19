package com.bootcamp.movies.controller;

import com.bootcamp.movies.dto.RespActorDTO;
import com.bootcamp.movies.model.Actor;
import com.bootcamp.movies.service.ActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final ActorService actorService;


    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    @RequestMapping("/who_have_favorite_movie")
    public ResponseEntity<List<RespActorDTO>> getActorsWhoHaveFavoriteMovie() {
        return new ResponseEntity<>(actorService.getAllActorWhoHaveFavoriteMovie(), HttpStatus.OK);
    }
}
