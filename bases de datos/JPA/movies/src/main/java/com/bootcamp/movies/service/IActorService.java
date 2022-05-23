package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.ActorDTO;
import java.util.List;

public interface IActorService {
    List<ActorDTO> getAllWithFavorites();
    List<ActorDTO> getAllWithoutFavorites();
    List<ActorDTO> getAllActorsMinRating(Double rating);
    List<ActorDTO> getAllActorsInMovie(Long id);
}
