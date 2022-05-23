package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.MovieDTO;

import java.util.List;

public interface IMovieService {
    List<MovieDTO> getAllMoviesActorRating(Double rating);
    List<MovieDTO> getAllMoviesByGenre(Long id);
}
