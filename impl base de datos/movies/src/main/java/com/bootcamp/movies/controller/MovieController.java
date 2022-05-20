package com.bootcamp.movies.controller;

import com.bootcamp.movies.dto.ActorDTO;
import com.bootcamp.movies.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping("/actors/with_favorite_movies")
    public ResponseEntity<List<ActorDTO>> getActorsWithFavMovie(){
        return ResponseEntity.ok().body(service.getActorsWithFavMovie());
    }
}
