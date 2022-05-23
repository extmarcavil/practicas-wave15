package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.ActorDTO;
import com.bootcamp.movies.model.Actor;
import com.bootcamp.movies.repository.ActorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService implements IActorService {

    private final ActorRepository actorRepository;
    private ModelMapper modelMapper;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    @Transactional( readOnly = true)
    public List<ActorDTO> getAllWithFavorites() {
        List<Actor> actorsList = actorRepository.findAllByFavoriteMovieIsNotNull();
        return actorsList.stream()
                .map(actor -> modelMapper.map(actor, ActorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorDTO> getAllWithoutFavorites() {
        List<Actor> actorsList = actorRepository.findAllByFavoriteMovieIsNull();
        return actorsList.stream()
                .map(actor -> modelMapper.map(actor, ActorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional( readOnly = true)
    public List<ActorDTO> getAllActorsMinRating(Double rating) {
        List<Actor> actorsList = actorRepository.findActorsByRatingIsGreaterThan(rating);
        return actorsList.stream()
                .map(actor -> modelMapper.map(actor, ActorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional( readOnly = true)
    public List<ActorDTO> getAllActorsInMovie(Long id) {
        List<Actor> actorsList = actorRepository.findActorsByMovie(id);
        return actorsList.stream()
                .map(actor -> modelMapper.map(actor, ActorDTO.class))
                .collect(Collectors.toList());
    }


}
