package com.example.hqlmoviesej1.service;

import com.example.hqlmoviesej1.dto.EpisodesDTO;
import com.example.hqlmoviesej1.model.Episodes;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEpisodesService {
    List<EpisodesDTO> findByActor(String firstName, String lastName);
}
