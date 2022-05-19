package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.RespEpisodeDTO;

import java.util.List;

public interface EpisodeService {
    List<RespEpisodeDTO> getAllEpisodesByActorByFirstNameAndLastName(String fisrtName, String lastName);
}
