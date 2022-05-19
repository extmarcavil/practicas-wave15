package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.RespEpisodeDTO;
import com.bootcamp.movies.model.Episode;
import com.bootcamp.movies.repository.EpisodeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodeServiceImpl implements EpisodeService{
    private final EpisodeRepository episodeRepository;
    private ModelMapper modelMapper;

    public EpisodeServiceImpl(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<RespEpisodeDTO> getAllEpisodesByActorByFirstNameAndLastName(String fisrtName, String lastName) {
        List<Episode> episodesList = episodeRepository.findEpisodesByActorByFirstNameAndLastName(fisrtName,lastName);
        return getRespEpisodeDTOS(episodesList);
    }

    private List<RespEpisodeDTO> getRespEpisodeDTOS(List<Episode> episodesList) {
        List<RespEpisodeDTO> episodesDTOList = episodesList
                .stream()
                .map(episode -> modelMapper.map(episode, RespEpisodeDTO.class))
                .collect(Collectors.toList());
        return episodesDTOList;
    }
}
