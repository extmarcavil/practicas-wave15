package com.example.starwars.repositories;

import com.example.starwars.dto.CharacterDTO;

import java.util.List;

public interface ICharacterRepository {
  List<CharacterDTO> findAllByNameContains(String query);
}
