package com.movies.demoHQL.service;

import com.movies.demoHQL.model.DTO.ActorDTO;
import com.movies.demoHQL.model.DTO.ActorMovieResponceDTO;
import com.movies.demoHQL.model.DTO.MovieDTO;

import java.util.List;

public interface IActorService {

    List<ActorDTO> getAllActors();

    ActorDTO getActorByName(String name);

    MovieDTO getMovieOfActor(Integer id);

    public ActorMovieResponceDTO getActorWithfavoriteMovie(String name);
}
