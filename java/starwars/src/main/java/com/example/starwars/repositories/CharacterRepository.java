package com.example.starwars.repositories;

import com.example.starwars.dto.CharacterDTO;

import java.util.List;

public interface CharacterRepository {
  List<CharacterDTO> findAllByNameContains(String query);
  CharacterDTO getCharacterInfo(String name);
}
