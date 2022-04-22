package com.example.starwars.service;

import com.example.starwars.dto.CharacterShowDTO;

import java.util.List;

public interface ICharacterService {
    List<CharacterShowDTO> getCharacters (String name);
}
