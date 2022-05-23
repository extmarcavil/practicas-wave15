package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.SerieDTO;
import com.bootcamp.movies.model.Movie;

import java.util.List;

public interface ISerieService {
    List<SerieDTO> findAllByCount(Integer count);
}
