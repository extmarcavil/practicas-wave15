package com.example.hqlmoviesej1.service;

import com.example.hqlmoviesej1.dto.ActorsDTO;
import com.example.hqlmoviesej1.repository.ActorsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorsService implements IActorsService{

    private final ActorsRepository actorsRepository;

    public ActorsService(ActorsRepository actorsRepository) {
        this.actorsRepository = actorsRepository;
    }

    @Override
    public List<ActorsDTO> findByMoviesIsNotNull() {
        ModelMapper modelMapper = new ModelMapper();
        return actorsRepository.findDistinctByMoviesIsNotNull()
                .stream()
                .map(a -> modelMapper.map(a, ActorsDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorsDTO> findByRatingGreaterThan(Double rating) {
        ModelMapper modelMapper = new ModelMapper();
        return actorsRepository.findDistinctByRatingGreaterThan(rating)
                .stream()
                .map(a -> modelMapper.map(a, ActorsDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorsDTO> findByMovies(String movie) {
        ModelMapper modelMapper = new ModelMapper();
        return actorsRepository.findByMovies(movie)
                .stream()
                .map(a -> modelMapper.map(a, ActorsDTO.class))
                .collect(Collectors.toList());
    }
}
