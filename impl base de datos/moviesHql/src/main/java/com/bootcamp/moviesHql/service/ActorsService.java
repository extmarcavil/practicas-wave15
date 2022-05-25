package com.bootcamp.moviesHql.service;

import com.bootcamp.moviesHql.dto.ActorDTO;
import com.bootcamp.moviesHql.model.Actors;
import com.bootcamp.moviesHql.repository.ActorsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorsService implements IActorsService {

    ActorsRepository repository;
    private final ModelMapper modelMapper;

    public ActorsService(ActorsRepository repository) {
        this.repository = repository;
        this.modelMapper = new ModelMapper();
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

    private List<ActorDTO> getActorDTOS(List<Actors> actorsList) {
        List<ActorDTO> actorsDTOList = actorsList
                .stream()
                .map(actor -> modelMapper.map(actor, ActorDTO.class))
                .collect(Collectors.toList());
        return actorsDTOList;
    }

    @Override
    public List<ActorDTO> getAllActorsMovie(Integer id) {
        List<Actors> actorsList = repository.getAllActorsMovie(id);
        return getActorDTOS(actorsList);
    }
}
