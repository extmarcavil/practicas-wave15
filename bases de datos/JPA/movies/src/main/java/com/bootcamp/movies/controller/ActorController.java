package com.bootcamp.movies.controller;

import com.bootcamp.movies.dto.ActorDTO;
import com.bootcamp.movies.service.IActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final IActorService iActorService;


    public ActorController(IActorService iActorService) {
        this.iActorService = iActorService;
    }

    @GetMapping
    @RequestMapping("/has_favorite")
    public ResponseEntity<List<ActorDTO>> getActorsWithFavorites() {
        return new ResponseEntity<>(iActorService.getAllWithFavorites(), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/no_has_favorite")
    public ResponseEntity<List<ActorDTO>> getActorsWithOutFavorites() {
        return new ResponseEntity<>(iActorService.getAllWithoutFavorites(), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/rating")
    public ResponseEntity<List<ActorDTO>> getAllActorsByRating(@RequestParam("rating") Double rating) {
        return new ResponseEntity<>(iActorService.getAllActorsMinRating(rating), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/actsInMovie")
    public ResponseEntity<List<ActorDTO>> getAllActorsWhoHaveFavoriteMovie(@RequestParam("movie") Long movieId) {
        return new ResponseEntity<>(iActorService.getAllActorsInMovie(movieId), HttpStatus.OK);
    }
}
