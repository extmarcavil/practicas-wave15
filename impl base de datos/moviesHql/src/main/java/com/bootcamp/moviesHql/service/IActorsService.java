package com.bootcamp.moviesHql.service;

import com.bootcamp.moviesHql.dto.ActorDTO;
import com.bootcamp.moviesHql.model.Actors;

import java.util.List;

public interface IActorsService {
    List<Actors> getAllFavorite();

    List<Actors> getAllRating(Double rating);

    List<ActorDTO> getAllActorsMovie(Integer id);
}
