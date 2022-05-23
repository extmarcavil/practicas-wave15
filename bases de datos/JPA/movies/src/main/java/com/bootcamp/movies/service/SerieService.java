package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.MovieDTO;
import com.bootcamp.movies.dto.SerieDTO;
import com.bootcamp.movies.model.Movie;
import com.bootcamp.movies.model.Serie;
import com.bootcamp.movies.repository.MovieRepository;
import com.bootcamp.movies.repository.SerieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class SerieService implements ISerieService{

    private final SerieRepository serieRepository;
    private ModelMapper modelMapper;

    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
        this.modelMapper = new ModelMapper();
    }


    @Override
    public List<SerieDTO> findAllByCount(Integer count) {
        List<Serie> serieList = serieRepository.findSerieBySeasonCount(count);
        return serieList.stream()
                .map(serie -> modelMapper.map(serie, SerieDTO.class))
                .collect(Collectors.toList());
    }
    }

