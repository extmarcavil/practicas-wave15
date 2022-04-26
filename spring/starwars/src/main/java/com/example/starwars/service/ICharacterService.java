package com.example.starwars.service;

import com.example.starwars.model.Character;

import java.util.List;

public interface ICharacterService {
    List<Character> getCharactersByName(String name);
}
