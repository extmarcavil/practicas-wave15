package com.movies.movies.controller;

import com.movies.movies.dto.MovieDTO;
import com.movies.movies.service.IMovieService;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private final IMovieService service;

    public MovieController(IMovieService service) {
        this.service = service;
    }

    @GetMapping("/movies")
    public List<MovieDTO> getMoviesByTLike(@Nullable @RequestParam String titleLike) {
        return titleLike == null ? service.getAllMovies() : service.getMoviesByTitleLike(titleLike);
    }

    @GetMapping("/moviesByRatingGreaterThan")
    public List<MovieDTO> getMoviesByRatingGreaterThan(@RequestParam Double lowerBound) {
        return service.getMoviesByRatingGreaterThan(lowerBound);
    }

    @GetMapping("/moviesByAwardsGreaterThan")
    public List<MovieDTO> getMoviesByAwardsGreaterThan(@RequestParam Integer awards) {
        return service.getMoviesByAwardsGreaterThan(awards);
    }
}