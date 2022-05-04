package com.example.starwars.service;

import com.example.starwars.dto.CharacterDTO;

import java.util.List;

public interface CharacterService {
    List<CharacterDTO> findAllByNameContains(String query);
}
