package com.bootcamp.movies.controller;

import com.bootcamp.movies.dto.MovieDTO;
import com.bootcamp.movies.service.IMovieService;
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
    private final IMovieService iMovieService;

    public MovieController(IMovieService iMovieService) {
        this.iMovieService = iMovieService;
    }

    @GetMapping
    @RequestMapping("/rating_actors")
    public ResponseEntity<List<MovieDTO>> getAllMoviesActorRating(@RequestParam("min") Double rating) {
        return new ResponseEntity<>(iMovieService.getAllMoviesActorRating(rating), HttpStatus.OK);
    }

   @GetMapping
    @RequestMapping("")
    public ResponseEntity<List<MovieDTO>> getAllMoviesByGenre(@RequestParam("genre") Long genre) {
        return new ResponseEntity<>(iMovieService.getAllMoviesByGenre(genre), HttpStatus.OK);
    }
}
