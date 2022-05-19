package com.bootcamp.hql.service;

import com.bootcamp.hql.dto.ActorDto;
import com.bootcamp.hql.dto.MovieDto;
import com.bootcamp.hql.model.Actors;
import com.bootcamp.hql.model.Movies;
import com.bootcamp.hql.repository.IMovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService implements IMovieService {

    private final IMovieRepository movieRepository;
    private final ModelMapper mapper;

    public MovieService(IMovieRepository movieRepository){
        this.movieRepository = movieRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public List<MovieDto> moviesByActorsRating(BigDecimal rating) {
        List<Movies> movies = movieRepository.moviesByActorsRating(rating);
        List<MovieDto> moviesDto = new ArrayList<>();
        for (Movies movie : movies) {
            moviesDto.add(mapper.map(movie, MovieDto.class));
        }
        return moviesDto;
    }

    @Override
    public List<MovieDto> moviesByGenre(String genre) {
        List<Movies> movies = movieRepository.moviesByGenre(genre);
        List<MovieDto> moviesDto = new ArrayList<>();
        for (Movies movie : movies) {
            moviesDto.add(mapper.map(movie, MovieDto.class));
        }
        return moviesDto;
    }
}
