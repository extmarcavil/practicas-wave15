package com.example.starwars.service;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.model.Character;
import com.example.starwars.repository.ICharacterRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterService implements ICharacterService{

    ICharacterRepository characterRepository;

    public CharacterService(ICharacterRepository characterRepository){
        this.characterRepository = characterRepository;
    }

    @Override
    public List<CharacterDTO> getCharacters(String name) {
        List<Character> characters = characterRepository.getCharacters(name);
        List<CharacterDTO> characterDTOS = new ArrayList<>();
        //Mapeo
        for (Character character : characters) {
            characterDTOS.add(new CharacterDTO(character));
        }
        return characterDTOS;
    }
}
