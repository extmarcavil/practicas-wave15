package com.bootcamp.moviesHql.service;

import com.bootcamp.moviesHql.dto.ActorDTO;
import com.bootcamp.moviesHql.dto.MoviesDTO;
import com.bootcamp.moviesHql.model.Actors;
import com.bootcamp.moviesHql.model.Movies;
import com.bootcamp.moviesHql.repository.MoviesRepository;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MoviesService {

    MoviesRepository repository;
    private ModelMapper mapper;

    public MoviesService(MoviesRepository repository) {
        this.repository = repository;
        this.mapper = new ModelMapper();
    }

    private List<MoviesDTO> getMovieDTOS(List<Movies> moviesList) {
        List<MoviesDTO> moviesDTOList = moviesList
                .stream().map(movie -> mapper.map(movie, MoviesDTO.class))
                .collect(Collectors.toList());
        return moviesDTOList;
    }

    public List<MoviesDTO> getAllMovieActorsRating(Double rating){
        List<Movies> moviesList = repository.findMoviesByActorsByRatingIsGreaterThan(rating);
        return getMovieDTOS(moviesList);
    }
}
