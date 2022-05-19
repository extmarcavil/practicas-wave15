package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.RespMovieDTO;
import com.bootcamp.movies.model.Movie;
import com.bootcamp.movies.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;
    private ModelMapper modelMapper;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<RespMovieDTO> getAllMoviesByActorsByRatingIsGreaterThan(Double rating) {
        List<Movie> moviesList = movieRepository.findMoviesByActorsByRatingIsGreaterThan(rating);
        return getRespMovieDTOS(moviesList);
    }

    @Override
    public List<RespMovieDTO> getAllMoviesByGenreName(String name) {
        List<Movie> moviesList = movieRepository.findMoviesByGenreName(name);
        return getRespMovieDTOS(moviesList);
    }

    private List<RespMovieDTO> getRespMovieDTOS(List<Movie> moviesList) {
        List<RespMovieDTO> moviesDTOList = moviesList
                .stream()
                .map(movie -> modelMapper.map(movie, RespMovieDTO.class))
                .collect(Collectors.toList());
        return moviesDTOList;
    }
}
