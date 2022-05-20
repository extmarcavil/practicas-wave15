package com.example.hql.service;

import com.example.hql.api.dto.MovieDto;
import com.example.hql.api.mapper.MovieMapper;
import com.example.hql.entity.Movie;
import com.example.hql.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;
    private final MovieMapper mapper;


    @Transactional(readOnly = true)
    public List<MovieDto> getMovies(BigDecimal rating, String genre) {
        Stream<Movie> stream;
        if (rating == null && genre == null)
            stream = repository.findAllMovies();
        else {
            if (rating == null) stream = repository.findByGenre(genre);
            else if (genre == null) stream = repository.findByActorRatingGreaterThan(rating);
            else stream = repository.findByGenreAndActorRatingGreaterThan(genre,rating);
        }
        return stream
                .map(movie -> mapper.movieToMovieDto(movie))
                .collect(Collectors.toList());
    }
}
