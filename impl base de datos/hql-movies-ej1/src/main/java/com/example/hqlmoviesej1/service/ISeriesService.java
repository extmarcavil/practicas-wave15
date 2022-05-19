package com.example.hqlmoviesej1.service;

import com.example.hqlmoviesej1.dto.SeriesDTO;
import com.example.hqlmoviesej1.model.Series;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISeriesService {
    List<SeriesDTO> findBySeasonsAmountGreatherThan(Integer amount);
}
