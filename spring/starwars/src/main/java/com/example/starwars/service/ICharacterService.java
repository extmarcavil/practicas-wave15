package com.example.starwars.service;

import com.example.starwars.dto.CharacterDTO;

import java.util.List;

public interface ICharacterService {
    List<CharacterDTO> getCharacter(String name);
}
