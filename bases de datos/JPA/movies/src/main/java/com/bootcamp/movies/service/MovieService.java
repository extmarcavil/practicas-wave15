package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.MovieDTO;
import com.bootcamp.movies.model.Movie;
import com.bootcamp.movies.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService {

    private final MovieRepository movieRepository;
    private ModelMapper modelMapper;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<MovieDTO> getAllMoviesActorRating(Double rating) {
        List<Movie> moviesList = movieRepository.findMoviesByActorRating(rating);
        return moviesList.stream()
                .map(movie -> modelMapper.map(movie, MovieDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> getAllMoviesByGenre(Long id) {
        List<Movie> moviesList = movieRepository.findMoviesByGenre(id);
        return moviesList.stream()
                .map(movie -> modelMapper.map(movie, MovieDTO.class))
                .collect(Collectors.toList());
    }

}
