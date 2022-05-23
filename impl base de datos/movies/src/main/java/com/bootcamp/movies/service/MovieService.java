package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.RespActorDTO;
import com.bootcamp.movies.dto.RespMovieDTO;

import java.util.List;

public interface MovieService {
    List<RespMovieDTO> getAllMoviesByActorsByRatingIsGreaterThan(Double rating);
    List<RespMovieDTO> getAllMoviesByGenreName(String name);
}
