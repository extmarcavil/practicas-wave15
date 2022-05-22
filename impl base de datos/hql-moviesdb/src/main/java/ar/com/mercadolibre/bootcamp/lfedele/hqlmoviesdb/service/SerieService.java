package ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.service;

import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.dto.SerieDto;

import java.util.List;

public interface SerieService {
    List<SerieDto> findAll();
    List<SerieDto> findAllWithMoreSeasonsThan(Integer seasons);
}
