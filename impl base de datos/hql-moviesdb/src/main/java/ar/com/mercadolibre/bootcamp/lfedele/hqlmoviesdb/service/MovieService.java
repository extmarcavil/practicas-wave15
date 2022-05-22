package ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.service;

import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.dto.MovieDto;

import java.util.List;

public interface MovieService {
    List<MovieDto> findAllWithActorsRatingGreaterThan(Integer rating);
    List<MovieDto> findAllWithGenre(String genre);
}
