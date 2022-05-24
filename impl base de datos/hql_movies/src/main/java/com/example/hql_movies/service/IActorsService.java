package com.example.hql_movies.service;

import com.example.hql_movies.dto.ActorsDTO;

import java.util.List;

public interface IActorsService {
    List<ActorsDTO> getActorsWithFavoriteMovie();

    List<ActorsDTO> getActorsWithRatingGreaterThan(Double rating);
}
