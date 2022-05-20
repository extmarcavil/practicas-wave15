package com.bootcamp.consultashql.service;

import com.bootcamp.consultashql.dto.SerieDTO;
import com.bootcamp.consultashql.model.Serie;
import com.bootcamp.consultashql.repository.ISerieRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService implements ISerieService {
    
    ISerieRepository repository;
    ModelMapper mapper;

    public SerieService(ISerieRepository repository) {
        this.repository = repository;
        this.mapper = new ModelMapper();
    }

    @Override
    public List<SerieDTO> findSeriesByAmountSeasonsGreaterThan(Long amount) {
        List<Serie> series = repository.findSeriesByAmountSeasonsGreaterThan(amount);
        return mapper.map(series, new TypeToken<List<SerieDTO>>() {}.getType());
    }
}
