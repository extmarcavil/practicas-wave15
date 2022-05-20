package com.meli.moviesHQL.service;


import com.meli.moviesHQL.model.DTO.ActorDTO;
import com.meli.moviesHQL.model.DTO.ActorMovieResponseDTO;
import com.meli.moviesHQL.model.DTO.MovieDTO;

import java.util.List;

public interface IActorService {

    List<ActorDTO> getAllActors();

    List<ActorDTO> getActorByName(String name);

    List<ActorDTO> getActorsWithFavoriteMovie();

    List<ActorDTO> getActorsWithRatingMoreAs(Double rating);

    List<ActorDTO> getActorsThatWorkInMovie(Integer movie);

    MovieDTO getMovieOfActor(Integer id);

    public List<ActorMovieResponseDTO>  getActorWithfavoriteMovie(String name);
}