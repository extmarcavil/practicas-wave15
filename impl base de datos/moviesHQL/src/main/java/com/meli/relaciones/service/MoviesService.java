package com.meli.relaciones.service;

import com.meli.relaciones.entities.Movie;
import com.meli.relaciones.repository.MoviesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService implements IMoviesService {

    MoviesRepository repo;

    public MoviesService(MoviesRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Movie> findMoviesWithActors(Double rating) {
        return repo.findMoviesWithActorByRating(rating);
    }
}
