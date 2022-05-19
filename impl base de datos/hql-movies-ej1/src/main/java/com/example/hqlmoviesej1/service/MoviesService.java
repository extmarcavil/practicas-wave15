package com.example.hqlmoviesej1.service;

import com.example.hqlmoviesej1.dto.ActorsDTO;
import com.example.hqlmoviesej1.dto.MoviesDTO;
import com.example.hqlmoviesej1.repository.MoviesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MoviesService implements IMoviesService{

    private final MoviesRepository moviesRepository;

    public MoviesService(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    @Override
    public List<MoviesDTO> findByActorsRatingGreatherThan(Double rating) {
        ModelMapper modelMapper = new ModelMapper();
        return moviesRepository.findByActorsRatingGreatherThan(rating)
                .stream()
                .map(a -> modelMapper.map(a, MoviesDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MoviesDTO> findByGenres(String genre) {
        ModelMapper modelMapper = new ModelMapper();
        return moviesRepository.findByGenres(genre)
                .stream()
                .map(a -> modelMapper.map(a, MoviesDTO.class))
                .collect(Collectors.toList());
    }
}
