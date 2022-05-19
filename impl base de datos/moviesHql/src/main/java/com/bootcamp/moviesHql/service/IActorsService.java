package com.bootcamp.moviesHql.service;

import com.bootcamp.moviesHql.dto.ActorDto;
import com.bootcamp.moviesHql.model.Actors;

import java.util.List;

public interface IActorsService {
    List<Actors> getAllFavorite();

    List<Actors> getAllRating(Double rating);

    List<ActorDto> getAllActorsMovie(String title);
}
