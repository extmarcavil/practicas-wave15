package com.starwar.starwarcharacters.service;

import com.starwar.starwarcharacters.dto.CharacterDTO;
import com.starwar.starwarcharacters.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService {

    private CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<CharacterDTO> getCharacters(String name){
        List<CharacterDTO> allCharacters = characterRepository.getCharacters();
        List<CharacterDTO> filterCharacters = allCharacters.stream().filter(c -> c.getName()
                                                                    .contains(name)).collect(Collectors.toList());


        return filterCharacters;
    }
}
