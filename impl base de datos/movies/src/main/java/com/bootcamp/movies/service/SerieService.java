package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.RespSerieDTO;

import java.util.List;

public interface SerieService {
    List<RespSerieDTO> getAllSeriesByAmountSeasonsIsGreaterThan(Long amount);
}
