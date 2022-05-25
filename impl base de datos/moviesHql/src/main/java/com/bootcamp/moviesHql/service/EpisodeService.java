package com.bootcamp.moviesHql.service;

import com.bootcamp.moviesHql.dto.EpisodeDTO;
import com.bootcamp.moviesHql.model.Episode;
import com.bootcamp.moviesHql.repository.EpisodeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodeService implements IEpisodeService {

    EpisodeRepository repository;
    private final ModelMapper mapper;

    public EpisodeService(EpisodeRepository repository) {
        this.repository = repository;
        this.mapper = new ModelMapper();
    }

    private List<EpisodeDTO> getEpisodeDTOS(List<Episode> episodesList) {
        List<EpisodeDTO> episodeDTOList = episodesList
                .stream().map(episode -> mapper.map(episode, EpisodeDTO.class))
                .collect(Collectors.toList());
        return episodeDTOList;
    }

    public List<EpisodeDTO> findAllEpisode(String firstname, String lastname){
        List<Episode> episodeList = repository.findAllWithActor(firstname, lastname);
        return getEpisodeDTOS(episodeList);
    }
}
