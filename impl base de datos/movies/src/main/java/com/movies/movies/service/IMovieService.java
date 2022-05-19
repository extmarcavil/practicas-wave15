package com.movies.movies.service;

import com.movies.movies.dto.MovieDTO;

import java.util.List;

public interface IMovieService {
    List<MovieDTO> getAllMovies();

    List<MovieDTO> getMoviesByTitleLike(String title);

    List<MovieDTO> getMoviesByRatingGreaterThan(Double bound);

    List<MovieDTO> getMoviesByAwardsGreaterThan(Integer awards);
}
