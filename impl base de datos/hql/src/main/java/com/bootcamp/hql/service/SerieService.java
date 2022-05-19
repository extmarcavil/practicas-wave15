package com.bootcamp.hql.service;

import com.bootcamp.hql.dto.MovieDto;
import com.bootcamp.hql.dto.SerieDto;
import com.bootcamp.hql.model.Movies;
import com.bootcamp.hql.model.Series;
import com.bootcamp.hql.repository.ISerieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SerieService implements ISerieService{

    private final ISerieRepository serieRepository;
    private final ModelMapper mapper;

    public SerieService(ISerieRepository serieRepository){
        this.serieRepository = serieRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public List<SerieDto> seriesBySeasons(Integer seasons) {
        List<Series> series = serieRepository.seriesBySeasons(seasons);
        List<SerieDto> seriesDto = new ArrayList<>();
        for (Series serie : series) {
            seriesDto.add(mapper.map(serie, SerieDto.class));
        }
        return seriesDto;
    }
}
