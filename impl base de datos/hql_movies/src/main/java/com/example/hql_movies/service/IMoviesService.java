package com.example.hql_movies.service;

import com.example.hql_movies.dto.ActorsDTO;
import com.example.hql_movies.dto.MoviesDTO;

import java.util.List;

public interface IMoviesService {
    List<ActorsDTO> getActorsByMovie(String movie);

    List<MoviesDTO> getMoviesOfActorsWithRatingGreaterThan(Double rating);

    List<MoviesDTO> getMoviesWithGenre(String genre);
}
