package ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.service.impl;

import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.dto.MovieDto;
import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.repository.MovieRepository;
import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final ModelMapper mapper;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
        this.mapper=new ModelMapper();
    }

    @Override
    public List<MovieDto> findAllWithActorsRatingGreaterThan(Integer rating) {
        return StreamSupport
                .stream(movieRepository.findAllWithActorsRatingGreaterThan(rating).spliterator(), false)
                .map(m -> mapper.map(m, MovieDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDto> findAllWithGenre(String genre) {
        return StreamSupport
                .stream(movieRepository.findAllWithGenre(genre).spliterator(), false)
                .map(m -> mapper.map(m, MovieDto.class))
                .collect(Collectors.toList());
    }
}
