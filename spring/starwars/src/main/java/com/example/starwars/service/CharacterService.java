package com.example.starwars.service;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.repositories.ICharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService implements ICharacterService{
    ICharacterRepository repository;

    public CharacterService(ICharacterRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CharacterDTO> getCharacter(String name) {
        List<CharacterDTO> personajes = null;
        try {
            personajes = repository.findAllByNameContains(name);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        return personajes;
    }

}
