package com.bootcamp.movies.controller;

import com.bootcamp.movies.dto.RespActorDTO;
import com.bootcamp.movies.model.Actor;
import com.bootcamp.movies.service.ActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return new ResponseEntity<>(actorService.getAllActorsWhoHaveFavoriteMovie(), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/rating")
    public ResponseEntity<List<RespActorDTO>> getAllActorsWhoHaveRatingGreaterThan(@RequestParam("greater_than") Double rating) {
        return new ResponseEntity<>(actorService.getAllActorsWhoHaveRatingGreaterThan(rating), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/movie")
    public ResponseEntity<List<RespActorDTO>> getAllActorsWhoHaveFavoriteMovie(@RequestParam("movie_name") String name) {
        return new ResponseEntity<>(actorService.getAllActorsWhoWorkingInTheMovieByName(name), HttpStatus.OK);
    }
}
