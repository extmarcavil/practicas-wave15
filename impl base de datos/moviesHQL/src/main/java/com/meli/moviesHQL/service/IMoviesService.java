package com.meli.moviesHQL.service;

import com.meli.moviesHQL.model.DTO.MovieDTO;

import java.util.List;

public interface IMoviesService {
    List<MovieDTO> getAllMovies();

    List<MovieDTO> getMoviesByTitleLike(String title);

    /*
    List<MovieDTO> getMoviesByRatingGreaterThan(Double bound);

    List<MovieDTO> getMoviesByAwardsGreaterThan(Integer awards);
    */
}
