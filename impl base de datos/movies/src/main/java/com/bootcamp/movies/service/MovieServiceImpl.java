package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.ActorDTO;
import com.bootcamp.movies.dto.MovieDTO;
import com.bootcamp.movies.repository.ActorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    private final ModelMapper modelMapper;
    private final ActorRepository actorRepository;

    public MovieServiceImpl(ActorRepository actorRepository) {
        this.modelMapper = new ModelMapper();
        this.actorRepository = actorRepository;
    }

    @Override
    public List<ActorDTO> getActorsWithFavMovie() {
        return actorRepository.findAllActorsByFavoriteMovieIsNotNull()
                .stream().map(actor -> modelMapper.map(actor, ActorDTO.class))
                .collect(Collectors.toList());
    }
}
