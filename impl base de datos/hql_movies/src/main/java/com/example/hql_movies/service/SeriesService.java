package com.example.hql_movies.service;

import com.example.hql_movies.dto.SeriesDTO;
import com.example.hql_movies.repository.ISeriesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeriesService implements ISeriesService {
    private final ISeriesRepository seriesRepository;
    private final ModelMapper mapper;

    public SeriesService(ISeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public List<SeriesDTO> getSeriesWithSeasonsAmountGreaterThan(Integer seasons) {
        return seriesRepository.findAllBySeasonsGreaterThan(seasons).stream()
                .map(v -> mapper.map(v, SeriesDTO.class)).collect(Collectors.toList());
    }
}
