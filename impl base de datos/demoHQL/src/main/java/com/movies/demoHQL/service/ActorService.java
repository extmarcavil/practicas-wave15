package com.movies.demoHQL.service;

import com.movies.demoHQL.model.Actor;
import com.movies.demoHQL.DTO.ActorDTO;
import com.movies.demoHQL.DTO.ActorMovieResponseDTO;
import com.movies.demoHQL.DTO.MovieDTO;
import com.movies.demoHQL.model.Movie;
import com.movies.demoHQL.repository.IActorRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService implements IActorService {

    @Autowired
    IActorRepository repository;

    @Autowired
    ModelMapper mapper;


    @Override
    public List<ActorDTO> getAllActors() {
        List<Actor> actors = repository.findAllActors();



        return actors.stream().map(actor -> mapper.map(actor, ActorDTO.class)).collect(Collectors.toList());
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


    public ActorMovieResponseDTO getActorWithfavoriteMovie(String name) {
        ActorMovieResponseDTO actorMovie = new ActorMovieResponseDTO();
        ActorDTO actor = getActorByName(name);
        MovieDTO movie = getMovieOfActor(actor.getFavoriteMovieId());
        actorMovie.setActor(actor);
        actorMovie.setFavoriteMovie(movie);

        return actorMovie;

    }

    public List<ActorMovieResponseDTO> getActorsWithFavoriteMovies(){
        List<Actor> actors = repository.findAllActorsFavoriteMovie();
        Type listType = new TypeToken<List<ActorMovieResponseDTO>>(){}.getType();
        return mapper.map(actors, listType);
    }

    public List<ActorMovieResponseDTO> getActorsByRating(Double rating){
        List<Actor> actors = repository.findAllActorsByRating(rating);
        Type listType = new TypeToken<List<ActorMovieResponseDTO>>(){}.getType();
        return mapper.map(actors, listType);
    }

    public List<ActorMovieResponseDTO> getActorsOfMovie(String movie){
        List<Actor> list = repository.findActorsByMovieName(movie);
        return list.stream().map(a -> mapper.map(a, ActorMovieResponseDTO.class)).collect(Collectors.toList());
    }

}