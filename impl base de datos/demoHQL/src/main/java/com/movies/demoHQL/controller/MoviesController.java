package com.movies.demoHQL.controller;

import com.movies.demoHQL.DTO.MovieDTO;
import com.movies.demoHQL.service.IMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoviesController {

    @Autowired
    IMoviesService service;

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
