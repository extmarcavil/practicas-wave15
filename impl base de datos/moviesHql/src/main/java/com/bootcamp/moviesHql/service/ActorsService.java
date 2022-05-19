package com.bootcamp.moviesHql.service;

import com.bootcamp.moviesHql.dto.ActorDto;
import com.bootcamp.moviesHql.model.Actors;
import com.bootcamp.moviesHql.repository.ActorsRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<ActorDto> getAllActorsMovie(String title) {
        List<Actors> actors = repository.getAllActorsMovie(title);
        List<ActorDto> actorsDto = getActorsDto(actors);
        return actorsDto;
    }

    private List<ActorDto> getActorsDto(List<Actors> actorsList) {
        ModelMapper modelMapper = new ModelMapper();
        List<ActorDto> actorsDTOList = actorsList
                .stream()
                .map(actor -> modelMapper.map(actor, ActorDto.class))
                .collect(Collectors.toList());
        return actorsDTOList;
    }
}
