package com.example.starwars.repositories;

import com.example.starwars.model.Character;

import java.util.List;

public interface CharacterRepository {
  List<Character> findAllByNameContains(String query);
}
