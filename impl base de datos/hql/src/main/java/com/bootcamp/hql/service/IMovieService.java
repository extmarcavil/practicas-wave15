package com.bootcamp.hql.service;

import com.bootcamp.hql.dto.MovieDto;

import java.math.BigDecimal;
import java.util.List;

public interface IMovieService {
    List<MovieDto> moviesByActorsRating(BigDecimal rating);
    List<MovieDto> moviesByGenre(String genre);
}
