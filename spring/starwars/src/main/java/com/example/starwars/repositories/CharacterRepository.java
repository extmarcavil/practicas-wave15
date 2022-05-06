package com.example.starwars.repositories;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.entities.Character;

import java.util.List;

public interface CharacterRepository {


    /**
     * Metodos
     *
     * @param query
     * @return
     */
    List<Character> findAll();

    List<Character> findAllByNameContains(String query);
}
