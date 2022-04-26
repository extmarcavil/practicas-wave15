package com.example.starwars.repositories;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.model.CharacterStar;

import java.util.List;

public interface CharacterRepository {
  List<CharacterStar> findAllByNameContains(String query);
}
