package com.meli.relaciones.service;

import com.meli.relaciones.entities.Movie;

import java.util.List;

public interface IMoviesService {
    List<Movie> findMoviesWithActors(Double rating);
}
