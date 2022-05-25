package com.example.hql_movies.service;

import com.example.hql_movies.dto.SeriesDTO;

import java.util.List;

public interface ISeriesService {
    List<SeriesDTO> getSeriesWithSeasonsAmountGreaterThan(Integer seasons);
}
