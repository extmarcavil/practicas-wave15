package com.meli.startwars.service;

import com.meli.startwars.dto.CharacterDto;
import com.meli.startwars.model.CharacterEntity;
import com.meli.startwars.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }
    
    public List<CharacterDto> findByName(String name) {
        return characterRepository.findAll().stream()
                .filter(character -> containsName(character, name))
                .map(CharacterDto::from)
                .collect(Collectors.toList());
    }
    private boolean containsName(CharacterEntity characterEntity, String name) {
        return characterEntity.getName().toLowerCase().contains(name.toLowerCase());
    }
}
