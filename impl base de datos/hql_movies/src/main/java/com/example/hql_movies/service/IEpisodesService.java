package com.example.hql_movies.service;

import com.example.hql_movies.dto.EpisodesDTO;

import java.util.List;

public interface IEpisodesService {
    List<EpisodesDTO> getEpisodesWithActor(String firstName, String lastName);
}
