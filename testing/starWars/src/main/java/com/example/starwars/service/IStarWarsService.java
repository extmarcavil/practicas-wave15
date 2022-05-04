package com.example.starwars.service;

import com.example.starwars.dto.CharacterDTO;

import java.util.List;

public interface IStarWarsService {
    List<CharacterDTO> findAllByNameContains(String query);
}
