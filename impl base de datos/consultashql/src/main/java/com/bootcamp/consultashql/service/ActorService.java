package com.bootcamp.consultashql.service;

import com.bootcamp.consultashql.dto.ActorDTO;
import com.bootcamp.consultashql.dto.ActorMovieResponseDTO;
import com.bootcamp.consultashql.dto.MovieDTO;
import com.bootcamp.consultashql.model.Actor;
import com.bootcamp.consultashql.model.Movie;
import com.bootcamp.consultashql.repository.IActorRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService implements IActorService{

    IActorRepository repository;
    ModelMapper mapper;

    public ActorService(IActorRepository repository) {
        this.repository = repository;
        this.mapper = new ModelMapper();
    }


    @Override
    public List<ActorDTO> getAllActors() {
        List<Actor> actors = repository.findAllActors();
        return mapper.map(actors, new TypeToken<List<ActorDTO>>() {}.getType());
    }

    @Override
    public List<ActorDTO> getActorsWithFavoriteMovie() {
        List<Actor> actors = repository.findActorsWithFavoriteMovie();
        return mapper.map(actors, new TypeToken<List<ActorDTO>>() {}.getType());
    }

    @Override
    public List<ActorDTO> getActorsWithRatingGreaterThan(Double rating) {
        List<Actor> actors = repository.findActorsWithRatingGreaterThan(rating);
        return mapper.map(actors, new TypeToken<List<ActorDTO>>() {}.getType());
    }

    @Override
    public List<ActorDTO> getActorsOfMovie(String movie) {
        List<Actor> actors = repository.findActorsOfMovie(movie);
        return mapper.map(actors, new TypeToken<List<ActorDTO>>() {}.getType());
    }

    @Override
    public ActorDTO getActorByName(String name) {
        Actor actor = repository.findByFirstName(name);
        return mapper.map(actor, ActorDTO.class);
    }

    @Override
    public MovieDTO getMovieOfActor(Integer id) {
        Movie movie = repository.findMovieOfActor(id);
        return mapper.map(movie, MovieDTO.class);
    }

    @Override
    public ActorMovieResponseDTO getActorWithfavoriteMovie(String name) {
        ActorMovieResponseDTO actorMovie = new ActorMovieResponseDTO();
        ActorDTO actor = getActorByName(name);
        MovieDTO movie = getMovieOfActor(actor.getFavoriteMovieId());
        actorMovie.setActor(actor);
        actorMovie.setFavoriteMovie(movie);
        return actorMovie;
    }

}
