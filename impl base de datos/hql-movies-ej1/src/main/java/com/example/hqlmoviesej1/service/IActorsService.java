package com.example.hqlmoviesej1.service;

import com.example.hqlmoviesej1.dto.ActorsDTO;
import com.example.hqlmoviesej1.model.Actors;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IActorsService {
    List<ActorsDTO> findByMoviesIsNotNull();

    List<ActorsDTO> findByRatingGreaterThan(Double rating);

    List<ActorsDTO> findByMovies(String movie);
}
