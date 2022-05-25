package com.bootcamp.moviesHql.service;

import com.bootcamp.moviesHql.dto.EpisodeDTO;

import java.util.List;

public interface IEpisodeService {

    List<EpisodeDTO> findAllEpisode(String firstname, String lastname);

}
