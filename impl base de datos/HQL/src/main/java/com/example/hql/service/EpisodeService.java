package com.example.hql.service;

import com.example.hql.api.dto.EpisodeDto;
import com.example.hql.api.mapper.EpisodeMapper;
import com.example.hql.repository.EpisodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EpisodeService {

    private final EpisodeRepository repository;
    private final EpisodeMapper mapper;

    @Transactional
    public List<EpisodeDto> getEpisodesByActor(String actor){
        return repository.findEpisodeByActorName(actor)
                .map(episode -> mapper.episodeToEpisodeDto(episode))
                .collect(Collectors.toList());
    }
}
