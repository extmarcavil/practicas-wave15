package com.bootcamp.consultashql.service;

import com.bootcamp.consultashql.dto.SerieDTO;

import java.util.List;

public interface ISerieService {

    List<SerieDTO> findSeriesByAmountSeasonsGreaterThan(Long amount);
}
