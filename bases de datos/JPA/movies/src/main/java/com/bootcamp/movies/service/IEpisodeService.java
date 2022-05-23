package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.EpisodeDTO;

import java.util.List;

public interface IEpisodeService {
    public List<EpisodeDTO> getAllEpisodes(Long idActor);
}
