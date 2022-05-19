package com.bootcamp.hql.service;

import com.bootcamp.hql.dto.EpisodeDto;
import com.bootcamp.hql.dto.SerieDto;
import com.bootcamp.hql.model.Episodes;
import com.bootcamp.hql.repository.IEpisodeRepository;
import com.bootcamp.hql.repository.ISerieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EpisodeSerivce implements IEpisodeService {

    private final IEpisodeRepository episodeRepository;
    private final ModelMapper mapper;

    public EpisodeSerivce(IEpisodeRepository episodeRepository){
        this.episodeRepository = episodeRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public List<EpisodeDto> episodesByActors(String actor) {
        List<Episodes> episodes = episodeRepository.episodesByActors(actor);
        List<EpisodeDto> episodesDto = new ArrayList<>();
        for (Episodes episode : episodes) {
            episodesDto.add(mapper.map(episode, EpisodeDto.class));
        }
        return episodesDto;
    }
}
