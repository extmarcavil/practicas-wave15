package com.p1vivo.starwars.repository;

import com.p1vivo.starwars.entity.Character;

import java.util.List;

public interface CharacterRepository {
  List<Character> findAllByNameContains(String query);
}
