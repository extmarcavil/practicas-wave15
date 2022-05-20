package com.movies.demoHQL.service;

import com.movies.demoHQL.model.Movie;
import com.movies.demoHQL.model.DTO.MovieDTO;
import com.movies.demoHQL.repository.IMoviesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MoviesService implements IMoviesService {

    @Autowired
    IMoviesRepository repository;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    ModelMapper mapper;

    @Override
    public List<MovieDTO> getAllMovies() {
        //List<Movie> movies = repository.findAll();       //Usando JPA
        List<Movie> movies = repository.findAllMovies();   //Usando HQL

        return movies.stream().map(movie -> mapper.map(movie, MovieDTO.class)).collect(Collectors.toList());
    }


    // COMO SI HACERLO :)
    @Override
    public List<MovieDTO> getMoviesByTitleLike(String title) {
        List<Movie> movies = repository.findMoviesByTitleLike(title);

        return movies.stream().map(movie -> mapper.map(movie, MovieDTO.class)).collect(Collectors.toList());
    }


    // COMO NO HACERLO 1! >:c
    @Override
    public List<MovieDTO> getMoviesByRatingGreaterThan(Double bound) {
        List<?> movies =    entityManager.createQuery("from Movie where rating > ?1")
                            .setParameter(1, bound)
                            .getResultList();

        return movies.stream().map(movie -> mapper.map(movie, MovieDTO.class)).collect(Collectors.toList());
    }


    // COMO NO HACERLO 2! >:c
    @Override
    public List<MovieDTO> getMoviesByAwardsGreaterThan(Integer awards) {
        TypedQuery<Movie> query = entityManager.createNamedQuery("MoviesByAwardsGreaterThan", Movie.class);
                            query.setParameter("awards", awards);
        List<Movie> movies = query.getResultList();

        return movies.stream().map(movie -> mapper.map(movie, MovieDTO.class)).collect(Collectors.toList());
    }
}
