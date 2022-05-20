package com.bootcamp.moviesHql.service;

import com.bootcamp.moviesHql.dto.ActorDto;
import com.bootcamp.moviesHql.model.Actors;

import java.util.List;

public interface IActorsService {
    List<ActorDto> getAllFavorite();

    List<ActorDto> getAllRating(Double rating);

    List<ActorDto> getAllActorsMovie(String title);
}
