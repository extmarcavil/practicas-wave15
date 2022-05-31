package com.example.ejerciciohqlmovies.service;

import com.example.ejerciciohqlmovies.dto.ActorDTO;
import com.example.ejerciciohqlmovies.model.Actor;

import java.util.List;

public interface IActorService {
    List<ActorDTO> findActorsWithFavouriteMovie();
}
