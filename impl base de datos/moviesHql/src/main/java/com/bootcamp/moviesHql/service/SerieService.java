package com.bootcamp.moviesHql.service;

import com.bootcamp.moviesHql.dto.SerieDTO;
import com.bootcamp.moviesHql.model.Serie;
import com.bootcamp.moviesHql.repository.SerieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService implements ISerieService {

    SerieRepository repository;
    private final ModelMapper mapper;

    public SerieService(SerieRepository repository) {
        this.repository = repository;
        this.mapper = new ModelMapper();
    }

    private List<SerieDTO> getSerieDTOS(List<Serie> seriesList) {
        List<SerieDTO> serieDTOList = seriesList
                .stream().map(serie -> mapper.map(serie, SerieDTO.class))
                .collect(Collectors.toList());
        return serieDTOList;
    }

    public List<SerieDTO> findAll(){
        List<Serie> seriesList = repository.findAll();
        return getSerieDTOS(seriesList);
    }

    public List<SerieDTO> findAllSerie(Integer season){
        List<Serie> seriesList = repository.findAllWithMoreSeasonsThan(season);
        return getSerieDTOS(seriesList);
    }
}
