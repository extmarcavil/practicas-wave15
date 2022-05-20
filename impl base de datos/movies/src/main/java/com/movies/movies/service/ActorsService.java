package com.movies.movies.service;

import com.movies.movies.model.Actor;
import com.movies.movies.model.Movie;
import com.movies.movies.repository.IActorsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorsService implements IActorsService{
    IActorsRepository actorsRepository;
    public ActorsService(IActorsRepository actorsRepository){
        this.actorsRepository=actorsRepository;
    }
    @Override
    public List<Actor> getAllFav() {
        return actorsRepository.findAllMoviesFav();
    }
}
