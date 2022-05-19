package com.bootcamp.hql.service;

import com.bootcamp.hql.dto.ActorDto;

import java.math.BigDecimal;
import java.util.List;

public interface IActorService {
    List<ActorDto> getAll();
    List<ActorDto> getAllActorsWithFavoriteMovie();
    List<ActorDto> actorsByRating(BigDecimal rating);
    List<ActorDto> actorsByMovie(String movie);
}
