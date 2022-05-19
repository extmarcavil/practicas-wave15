package com.example.hqlmoviesej1.service;

import com.example.hqlmoviesej1.dto.ActorsDTO;
import com.example.hqlmoviesej1.dto.EpisodesDTO;
import com.example.hqlmoviesej1.repository.EpisodesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodesService implements IEpisodesService{

    private final EpisodesRepository episodesRepository;

    public EpisodesService(EpisodesRepository episodesRepository) {
        this.episodesRepository = episodesRepository;
    }

    @Override
    public List<EpisodesDTO> findByActor(String firstName, String lastName) {
        ModelMapper modelMapper = new ModelMapper();
        return episodesRepository.findByActor(firstName, lastName)
                .stream()
                .map(a -> modelMapper.map(a, EpisodesDTO.class))
                .collect(Collectors.toList());
    }
}
