package com.bootcamp.hql.service;

import com.bootcamp.hql.dto.EpisodeDto;

import java.util.List;

public interface IEpisodeService {
    List<EpisodeDto> episodesByActors(String actor);
}
