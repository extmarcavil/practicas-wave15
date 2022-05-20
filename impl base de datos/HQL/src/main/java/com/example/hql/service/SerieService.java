package com.example.hql.service;

import com.example.hql.api.dto.SeriesDto;
import com.example.hql.api.mapper.SeriesMapper;
import com.example.hql.entity.Series;
import com.example.hql.repository.SeriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class SerieService {

    private final SeriesRepository repository;
    private final SeriesMapper mapper;

    @Transactional(readOnly = true)
    public List<SeriesDto> getSeries(Long cant){
        Stream<Series> stream;
        if (cant == null) stream = repository.findSeries();
        else stream=repository.findSeriesBySeasonCountGreaterThan(cant);

        return stream
                .map(series -> mapper.seriesToSeriesDto(series))
                .collect(Collectors.toList());
    }
}
