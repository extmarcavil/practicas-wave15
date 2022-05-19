package com.movies.demoHQL.service;

import com.movies.demoHQL.DTO.ActorDTO;
import com.movies.demoHQL.DTO.ActorMovieResponseDTO;
import com.movies.demoHQL.DTO.MovieDTO;

import java.util.List;

public interface IActorService {

    List<ActorDTO> getAllActors();

    ActorDTO getActorByName(String name);

    MovieDTO getMovieOfActor(Integer id);

    public ActorMovieResponseDTO getActorWithfavoriteMovie(String name);

    List<ActorMovieResponseDTO> getActorsWithFavoriteMovies();

    List<ActorMovieResponseDTO> getActorsByRating(Double rating);

    List<ActorMovieResponseDTO> getActorsOfMovie(String movie);
}
