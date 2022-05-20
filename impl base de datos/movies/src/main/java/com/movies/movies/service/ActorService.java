package com.movies.movies.service;

import com.movies.movies.dto.ActorDTO;
import com.movies.movies.models.Actor;
import com.movies.movies.repository.ActorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorService implements IActorService{
    private final ActorRepository actorRepo;

    public ActorService(ActorRepository actorRepo) {
        this.actorRepo = actorRepo;
    }

    @Override
    public List<ActorDTO> getActorsFavMovie() {
        ModelMapper mapper = new ModelMapper();

        List<Actor> list_actors = actorRepo.findActorByFavourite_movie();
        List<ActorDTO> actors = new ArrayList<>();

        list_actors.forEach((actor) -> actors.add(mapper.map(actor,ActorDTO.class)));

        return actors;
    }

    public List<ActorDTO> findActorByRating(double rating){
        ModelMapper mapper = new ModelMapper();

        List<Actor> list_actors = actorRepo.findActorByRating(rating);
        List<ActorDTO> actors = new ArrayList<>();

        list_actors.forEach((actor) -> actors.add(mapper.map(actor,ActorDTO.class)));

        return actors;
    }

    public List<ActorDTO> findActorByTitle(String title){
        ModelMapper mapper = new ModelMapper();

        List<Actor> list_actors = actorRepo.findActorByTitle(title);
        List<ActorDTO> actors = new ArrayList<>();

        list_actors.forEach((actor) -> actors.add(mapper.map(actor,ActorDTO.class)));

        return actors;
    }
}
