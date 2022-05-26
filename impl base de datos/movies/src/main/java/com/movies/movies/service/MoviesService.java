package com.movies.movies.service;

import com.movies.movies.dto.MovieDTO;
import com.movies.movies.models.Movie;
import com.movies.movies.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MoviesService implements IMovieService {

    private final MovieRepository movieRepo;


    public MoviesService(MovieRepository movieRepo) {
        this.movieRepo = movieRepo;

    }

    @Override
    public List<MovieDTO> getAllMovies() {
        ModelMapper mapper = new ModelMapper();

        //List<Movie> movies = repository.findAll();       //Usando JPA
        List<Movie> movies = movieRepo.findAllMovies();   //Usando HQL

        return movies.stream().map(movie -> mapper.map(movie, MovieDTO.class)).collect(Collectors.toList());
    }


    // COMO SI HACERLO :)
    @Override
    public List<MovieDTO> getMoviesByTitleLike(String title) {
        ModelMapper mapper = new ModelMapper();
        List<Movie> movies = movieRepo.findMoviesByTitleLike(title);

        return movies.stream().map(movie -> mapper.map(movie, MovieDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> getMoviesByRatingGreaterThan(Double bound) {
        return null;
    }

    @Override
    public List<MovieDTO> getMoviesByAwardsGreaterThan(Integer awards) {
        return null;
    }

}