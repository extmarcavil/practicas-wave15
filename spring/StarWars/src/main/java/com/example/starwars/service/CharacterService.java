package com.example.starwars.service;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.dto.CharacterShowDTO;
import com.example.starwars.repositories.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService implements ICharacterService{

    CharacterRepository repository;

    public CharacterService(CharacterRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CharacterShowDTO> getCharacters(String name) {
        List<CharacterShowDTO> characterShow = repository.findAllByNameContains(name)
                .stream()
                .map(characterContains -> new CharacterShowDTO(characterContains.getName(), characterContains.getBirth_year(),
                        characterContains.getGender(), characterContains.getHomeworld(), characterContains.getSpecies(),
                        characterContains.getHeight(), characterContains.getMass()))
                .collect(Collectors.toList());

        return characterShow;
    }
}
