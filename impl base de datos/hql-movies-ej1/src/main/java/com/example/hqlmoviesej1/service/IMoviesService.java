package com.example.hqlmoviesej1.service;


import com.example.hqlmoviesej1.dto.MoviesDTO;

import java.util.List;

public interface IMoviesService {
    List<MoviesDTO> findByActorsRatingGreatherThan(Double rating);
    List<MoviesDTO> findByGenres(String genre);
}
