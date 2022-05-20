package com.movies.movies.service;

import com.movies.movies.dto.ActorDTO;
import com.movies.movies.models.Actor;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IActorService {
    List<ActorDTO> getActorsFavMovie();
    List<ActorDTO> findActorByRating(double rating);
    List<ActorDTO> findActorByTitle(String title);
}
