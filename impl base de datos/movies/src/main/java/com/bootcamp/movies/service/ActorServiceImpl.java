package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.RespActorDTO;
import com.bootcamp.movies.model.Actor;
import com.bootcamp.movies.repository.ActorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements ActorService{

    private final ActorRepository actorRepository;
    private ModelMapper modelMapper;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<RespActorDTO> getAllActorWhoHaveFavoriteMovie() {
        List<Actor> actorsList = actorRepository.findAllByMoviesByFavoriteMovieIdIsNotNull();
        List<RespActorDTO> actorsDTOList =actorsList
                .stream()
                .map(actor -> modelMapper.map(actor, RespActorDTO.class))
                .collect(Collectors.toList());
        return actorsDTOList;
    }
}
