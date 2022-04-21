package com.example.starwars.service;

import com.example.starwars.model.Character;
import com.example.starwars.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements ICharacterService{

    @Autowired
    CharacterRepository characterRepository;

    @Override
    public List<Character> getCharactersByName(String name) {
        return characterRepository.findAllByNameContains(name);
    }
}
