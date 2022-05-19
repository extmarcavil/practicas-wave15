package com.meli.relaciones.controller;

import com.meli.relaciones.entities.Movie;
import com.meli.relaciones.service.IMoviesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MoviesController {
    IMoviesService service;

    public MoviesController(IMoviesService service) {
        this.service = service;
    }

    @GetMapping("/movies/actors/{rating}")
    public ResponseEntity<List<Movie>> findMoviesWithActorByRating(@PathVariable Double rating) {
        return ResponseEntity.ok(service.findMoviesWithActors(rating));
    }
}
