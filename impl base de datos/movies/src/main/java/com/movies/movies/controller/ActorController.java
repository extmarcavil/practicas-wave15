package com.movies.movies.controller;

import com.movies.movies.dto.ActorDTO;
import com.movies.movies.service.IActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final IActorService service;

    public ActorController(IActorService service) {
        this.service = service;
    }

    @GetMapping("/favourite_movies")
    public ResponseEntity<List<ActorDTO>> getActorsFavMovies(){
        return  ResponseEntity.ok().body(service.getActorsFavMovie());
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<ActorDTO>> getActorsByRating(@PathVariable double rating){
        return  ResponseEntity.ok().body(service.findActorByRating(rating));
    }

    @GetMapping("/title/{movie_title}")
    public ResponseEntity<List<ActorDTO>> getActorsByRating(@PathVariable String movie_title){
        return  ResponseEntity.ok().body(service.findActorByTitle(movie_title));
    }
}
