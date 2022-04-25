package com.p1vivo.starwars.service;

import com.p1vivo.starwars.dto.CharacterDTO;
import com.p1vivo.starwars.entity.Character;
import com.p1vivo.starwars.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarWarsServiceImpl implements IStarWarsService {

    private CharacterRepository characterRepository;

    public StarWarsServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<CharacterDTO> findAllByNameContains(String query) {
        List<Character> characters = characterRepository.findAllByNameContains(query);
        List<CharacterDTO> characterDTOS = characters.stream()
                .map(c -> new CharacterDTO(c.getName(),c.getHeight(), c.getMass(), c.getGender(),c.getHomeworld(), c.getSpecies()))
                .collect(Collectors.toList());
        return characterDTOS;
    }
}
