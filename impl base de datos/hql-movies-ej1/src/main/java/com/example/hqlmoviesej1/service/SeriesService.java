package com.example.hqlmoviesej1.service;

import com.example.hqlmoviesej1.dto.SeriesDTO;
import com.example.hqlmoviesej1.repository.SeriesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeriesService implements ISeriesService{

    private final SeriesRepository seriesRepository;

    public SeriesService(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    @Override
    public List<SeriesDTO> findBySeasonsAmountGreatherThan(Integer amount) {
        ModelMapper modelMapper = new ModelMapper();
        return seriesRepository.findBySeasonsAmountGreaterThan(amount)
                .stream()
                .map(a -> modelMapper.map(a, SeriesDTO.class))
                .collect(Collectors.toList());
    }
}
