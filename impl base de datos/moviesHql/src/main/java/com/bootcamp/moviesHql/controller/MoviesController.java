package com.bootcamp.moviesHql.controller;

import com.bootcamp.moviesHql.dto.MoviesDTO;
import com.bootcamp.moviesHql.service.IMoviesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/movies")
@RestController
public class  MoviesController {

    IMoviesService service;

    public MoviesController(IMoviesService service) {
        this.service = service;
    }

    @GetMapping("/rating")
    public ResponseEntity<List<MoviesDTO>> getAllMovieActorsRating(@RequestParam Double id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllMovieActorsRating(id));
    }

    @GetMapping("/withgenre/{genre}")
    public ResponseEntity<List<MoviesDTO>> findAllWithGenre(@PathVariable String genre) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllWithGenre(genre));
    }
}
