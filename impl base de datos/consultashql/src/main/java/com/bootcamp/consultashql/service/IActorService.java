package com.bootcamp.consultashql.service;

import com.bootcamp.consultashql.dto.ActorDTO;
import com.bootcamp.consultashql.dto.ActorMovieResponseDTO;
import com.bootcamp.consultashql.dto.MovieDTO;

import java.util.List;

public interface IActorService {

    List<ActorDTO> getAllActors();

    List<ActorDTO> getActorsWithFavoriteMovie();

    ActorDTO getActorByName(String name);

    MovieDTO getMovieOfActor(Integer id);

   ActorMovieResponseDTO getActorWithfavoriteMovie(String name);

    List<ActorDTO> getActorsWithRatingGreaterThan(Double rating);

    List<ActorDTO> getActorsOfMovie(String movie);
}
