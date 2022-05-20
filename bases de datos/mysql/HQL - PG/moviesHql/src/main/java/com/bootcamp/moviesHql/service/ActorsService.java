package com.bootcamp.moviesHql.service;

import com.bootcamp.moviesHql.model.Actors;
import com.bootcamp.moviesHql.repository.ActorsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorsService implements IActorsService{

    ActorsRepository repository;

    public ActorsService(ActorsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Actors> getAllFavorite() {

        List<Actors> actors = repository.getAllFavorite();
        return actors;
    }

    @Override
    public List<Actors> getAllRating(Double rating) {
        List<Actors> actors = repository.getAllRating(rating);
        return actors;
    }

    @Override
    public List<Actors> getAllActorsMovie(Integer id) {
        List<Actors> actors = repository.getAllActorsMovie(id);
        return actors;
    }
}
