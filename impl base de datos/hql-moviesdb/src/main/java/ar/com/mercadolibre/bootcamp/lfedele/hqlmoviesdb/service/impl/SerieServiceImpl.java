package ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.service.impl;

import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.dto.SerieDto;
import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.model.Serie;
import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.repository.SerieRepository;
import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.service.SerieService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SerieServiceImpl implements
        SerieService {
    private final SerieRepository serieRepository;
    private final ModelMapper mapper;

    public SerieServiceImpl(SerieRepository serieRepository){
        this.serieRepository=serieRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public List<SerieDto> findAll() {
        return StreamSupport
                .stream(serieRepository.findAll().spliterator(), false)
                .map(s -> mapper.map(s, SerieDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<SerieDto> findAllWithMoreSeasonsThan(Integer seasons) {
        return mapResult(serieRepository.findAllWithMoreSeasonsThan(seasons));
    }

    private List<SerieDto> mapResult(List<Serie> series) {
        return series
                .stream()
                .map(s -> mapper.map(s, SerieDto.class))
                .collect(Collectors.toList());
    }
}
