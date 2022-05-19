package com.example.hqlmoviesej1.controller;

import com.example.hqlmoviesej1.dto.EpisodesDTO;
import com.example.hqlmoviesej1.dto.MoviesDTO;
import com.example.hqlmoviesej1.service.IActorsService;
import com.example.hqlmoviesej1.service.IMoviesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private final IMoviesService moviesService;

    public MoviesController(IMoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping("/with-actor-rating/{rating}")
    ResponseEntity<List<MoviesDTO>> getMoviesWithActorRatingGreaterThan(@PathVariable Double rating){
        return ResponseEntity.ok(moviesService.findByActorsRatingGreatherThan(rating));
    }

    @GetMapping("/with-genre/{genre}")
    ResponseEntity<List<MoviesDTO>> getMoviesWithGenre(@PathVariable String genre){
        return ResponseEntity.ok(moviesService.findByGenres(genre));
    }
}
