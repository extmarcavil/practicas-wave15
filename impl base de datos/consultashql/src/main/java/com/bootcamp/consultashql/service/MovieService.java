package com.bootcamp.consultashql.service;

import com.bootcamp.consultashql.dto.ActorDTO;
import com.bootcamp.consultashql.dto.MovieDTO;
import com.bootcamp.consultashql.model.Movie;
import com.bootcamp.consultashql.repository.IActorRepository;
import com.bootcamp.consultashql.repository.IMoviesRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMoviesService {

    IMoviesRepository repository;
    ModelMapper mapper;

    public MovieService(IMoviesRepository repository) {
        this.repository = repository;
        this.mapper = new ModelMapper();
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = repository.findAllMovies();
        return mapper.map(movies, new TypeToken<List<MovieDTO>>() {}.getType());
    }

    @Override
    public List<MovieDTO> getMoviesByTitleLike(String title) {
        List<Movie> movies = repository.findMoviesByTitleLike(title);
        return mapper.map(movies, new TypeToken<List<MovieDTO>>() {}.getType());
    }

    @Override
    public List<MovieDTO> getMoviesByActorsWithRatingGreaterThan(Double rating) {
        List<Movie> movies = repository.findMoviesByActorsWithRatingIsGreaterThan(rating);
        return mapper.map(movies, new TypeToken<List<MovieDTO>>() {}.getType());
    }

    @Override
    public List<MovieDTO> getMoviesByGenre(String genre) {
        List<Movie> movies = repository.findMoviesByGenre(genre);
        return mapper.map(movies, new TypeToken<List<MovieDTO>>() {}.getType());
    }

}
