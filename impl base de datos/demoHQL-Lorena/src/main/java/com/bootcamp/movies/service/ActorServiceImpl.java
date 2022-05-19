package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.RespActorDTO;
import com.bootcamp.movies.model.Actor;
import com.bootcamp.movies.repository.ActorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional( readOnly = true)
    public List<RespActorDTO> getAllActorsWhoHaveFavoriteMovie() {
        List<Actor> actorsList = actorRepository.findAllByMoviesByFavoriteMovieIdIsNotNull();
        return getRespActorDTOS(actorsList);
    }

    @Override
    @Transactional( readOnly = true)
    public List<RespActorDTO> getAllActorsWhoHaveRatingGreaterThan(Double rating) {
        List<Actor> actorsList = actorRepository.findActorsByRatingIsGreaterThan(rating);
        return getRespActorDTOS(actorsList);
    }

    @Override
    @Transactional( readOnly = true)
    public List<RespActorDTO> getAllActorsWhoWorkingInTheMovieByName(String name) {
        List<Actor> actorsList = actorRepository.findActorsByMovieName(name);
        return getRespActorDTOS(actorsList);
    }

    private List<RespActorDTO> getRespActorDTOS(List<Actor> actorsList) {
        List<RespActorDTO> actorsDTOList = actorsList
                .stream()
                .map(actor -> modelMapper.map(actor, RespActorDTO.class))
                .collect(Collectors.toList());
        return actorsDTOList;
    }
}
