package com.bootcamp.moviesHql.service;

import com.bootcamp.moviesHql.dto.SerieDTO;

import java.util.List;

public interface ISerieService {

    List<SerieDTO> findAllSerie(Integer season);

    List<SerieDTO> findAll();

}
