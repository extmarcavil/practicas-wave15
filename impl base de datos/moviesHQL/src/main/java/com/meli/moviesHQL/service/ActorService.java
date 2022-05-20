package com.meli.moviesHQL.service;


import com.meli.moviesHQL.model.Actor;
import com.meli.moviesHQL.model.DTO.ActorDTO;
import com.meli.moviesHQL.model.DTO.ActorMovieResponseDTO;
import com.meli.moviesHQL.model.DTO.MovieDTO;
import com.meli.moviesHQL.model.Movie;
import com.meli.moviesHQL.repository.IActorRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService implements IActorService {

    //@Autowired
    IActorRepository repository;

    public ActorService(IActorRepository repository){
        this.repository = repository;
        //this.mapper = mapper;
    }

    @Override
    public List<ActorDTO> getAllActors() {
        List<Actor> actors = repository.findAllActors();
        ModelMapper mapper = new ModelMapper();
        return actors.stream().map(actor -> mapper.map(actor, ActorDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ActorDTO> getActorByName(String name) {
        List<Actor> actors = repository.findByFirstName(name);
        ModelMapper mapper = new ModelMapper();
        //return mapper.map(actor, ActorDTO.class);
        return actors.stream().map(actor -> mapper.map(actor, ActorDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ActorDTO> getActorsWithFavoriteMovie() {
        List<Actor> actors = repository.getActorsWithFavoriteMovie();
        ModelMapper mapper = new ModelMapper();
        return actors.stream().map(actor -> mapper.map(actor, ActorDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ActorDTO> getActorsWithRatingMoreAs(Double rating) {
        List<Actor> actors = repository.getActorsWithRatingMoreAs(rating);
        ModelMapper mapper = new ModelMapper();
        return actors.stream().map(actor -> mapper.map(actor, ActorDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ActorDTO> getActorsThatWorkInMovie(Integer movie) {
        return null;
    }


    @Override
    public MovieDTO getMovieOfActor(Integer id) {
        Movie movie = repository.findMovieOfActor(id);
        ModelMapper mapper = new ModelMapper();
        return mapper.map(movie, MovieDTO.class);
    }


    public List<ActorMovieResponseDTO> getActorWithfavoriteMovie(String name) {

        List<ActorMovieResponseDTO> list = new ArrayList<>();

        //ActorMovieResponseDTO actorMovie = new ActorMovieResponseDTO();
        //ActorDTO actor = getActorByName(name);

        List<ActorDTO> actors = getActorByName(name);

        for(ActorDTO actor:actors) {
            MovieDTO movie = getMovieOfActor(actor.getFavoriteMovieId());
            ActorMovieResponseDTO actorMovie = new ActorMovieResponseDTO();
            actorMovie.setActor(actor);
            actorMovie.setFavoriteMovie(movie);
            list.add(actorMovie);
        }
        /*
        MovieDTO movie = getMovieOfActor(actor.getFavoriteMovieId());
        actorMovie.setActor(actor);
        actorMovie.setFavoriteMovie(movie);
        */

        return list;

    }


}