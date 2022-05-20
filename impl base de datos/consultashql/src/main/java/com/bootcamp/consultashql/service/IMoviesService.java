package com.bootcamp.consultashql.service;

import com.bootcamp.consultashql.dto.MovieDTO;

import java.util.List;

public interface IMoviesService {
    List<MovieDTO> getAllMovies();

    List<MovieDTO> getMoviesByTitleLike(String title);

    List<MovieDTO> getMoviesByActorsWithRatingGreaterThan(Double rating);

    List<MovieDTO> getMoviesByGenre(String genre);
}
