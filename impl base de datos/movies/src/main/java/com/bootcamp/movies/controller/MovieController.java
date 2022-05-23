package com.bootcamp.movies.controller;

import com.bootcamp.movies.dto.RespActorDTO;
import com.bootcamp.movies.dto.RespMovieDTO;
import com.bootcamp.movies.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    @RequestMapping("/rating_actors")
    public ResponseEntity<List<RespMovieDTO>> getAllMoviesByActorsWithRatingGreaterThan(@RequestParam("greater_than") Double rating) {
        return new ResponseEntity<>(movieService.getAllMoviesByActorsByRatingIsGreaterThan(rating), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("")
    public ResponseEntity<List<RespMovieDTO>> getAllMoviesByActorsWithRatingGreaterThan(@RequestParam("genre") String name) {
        return new ResponseEntity<>(movieService.getAllMoviesByGenreName(name), HttpStatus.OK);
    }
}
