package com.bootcamp.hql.service;

import com.bootcamp.hql.dto.SerieDto;

import java.util.List;

public interface ISerieService {
    List<SerieDto> seriesBySeasons(Integer seasons);
}
