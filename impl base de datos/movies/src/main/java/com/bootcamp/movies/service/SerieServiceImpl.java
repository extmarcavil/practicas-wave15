package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.RespSerieDTO;
import com.bootcamp.movies.model.Serie;
import com.bootcamp.movies.repository.SerieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieServiceImpl implements SerieService{
    private final SerieRepository serieRepository;
    private ModelMapper modelMapper;

    public SerieServiceImpl(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<RespSerieDTO> getAllSeriesByAmountSeasonsIsGreaterThan(Long amount) {
        List<Serie> seriesList = serieRepository.findSeriesByAmountSeasonsIsGreaterThan(amount);
        return getRespSerieDTOS(seriesList);
    }

    private List<RespSerieDTO> getRespSerieDTOS(List<Serie> seriesList) {
        List<RespSerieDTO> seriesDTOList = seriesList
                .stream()
                .map(serie -> modelMapper.map(serie, RespSerieDTO.class))
                .collect(Collectors.toList());
        return seriesDTOList;
    }
}
