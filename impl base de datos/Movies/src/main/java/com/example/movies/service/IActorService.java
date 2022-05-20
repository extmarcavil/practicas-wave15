package com.example.movies.service;

import com.example.movies.dto.response.ActorsResponseDTO;

import java.util.List;

public interface IActorService {
    public List<ActorsResponseDTO> findActorsWihtFavoriteMovie();
}
