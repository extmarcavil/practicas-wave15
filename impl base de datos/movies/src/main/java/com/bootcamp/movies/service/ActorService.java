package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.RespActorDTO;
import com.bootcamp.movies.model.Actor;

import java.util.List;

public interface ActorService {
    List<RespActorDTO> getAllActorWhoHaveFavoriteMovie();
}
