package com.bootcamp.moviesHql.service;

import com.bootcamp.moviesHql.dto.MoviesDTO;

import java.util.List;

public interface IMoviesService {

    List<MoviesDTO> getAllMovieActorsRating(Double id);

    List<MoviesDTO> findAllWithGenre(String genre);

}
