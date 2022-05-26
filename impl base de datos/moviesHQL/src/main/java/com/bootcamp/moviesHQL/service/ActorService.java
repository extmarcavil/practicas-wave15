package com.bootcamp.moviesHQL.service;

import com.bootcamp.moviesHQL.dto.RespActorDTO;
import com.bootcamp.moviesHQL.model.Actor;
import com.bootcamp.moviesHQL.repository.ActorRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class ActorService implements IActorService{

    private final ActorRepository repository;
    private ModelMapper  modelMapper;

    public ActorService(ActorRepository repository) {

        this.repository = repository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<RespActorDTO> findAllActorsWithFavoriteMovie() {
        List<Actor> actorList = repository.findAllByMoviesByFavoriteMovieIdIsNotNull()
        return getRespActorDTOS(actorList);
    }

    @Override
    public List<Actor> findAllActorsByRating(Double rating) {
        return null;
    }

    private List<RespActorDTO> getRespActorDTOS(List<Actor> actorsList) {
        List<RespActorDTO> actorsDTOList = actorsList
                .stream()
                .map(actor -> modelMapper.map(actor, RespActorDTO.class))
                .collect(Collectors.toList());
        return actorsDTOList;
    }
}
