package com.meli.starwars.repositories;

import com.meli.starwars.dto.CharacterDTO;

import java.util.List;

public interface CharacterRepository {
    List<CharacterDTO> findAllByNameContains(String query);
}
