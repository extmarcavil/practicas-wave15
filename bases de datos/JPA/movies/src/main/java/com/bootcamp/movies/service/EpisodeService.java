package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.ActorDTO;
import com.bootcamp.movies.dto.EpisodeDTO;
import com.bootcamp.movies.model.Actor;
import com.bootcamp.movies.model.Episode;
import com.bootcamp.movies.repository.ActorRepository;
import com.bootcamp.movies.repository.EpisodeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodeService implements IEpisodeService{
    private final EpisodeRepository episodeRepository;
    private ModelMapper modelMapper;

    public EpisodeService(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
        this.modelMapper = new ModelMapper();
    }
    @Override
    public List<EpisodeDTO> getAllEpisodes(Long idActor) {
        List<Episode> episodesList = episodeRepository.findEpisodeByIdActor(idActor);
        return   episodesList.stream()
                .map(episode -> modelMapper.map(episode, EpisodeDTO.class))
                .collect(Collectors.toList());
    }
}
