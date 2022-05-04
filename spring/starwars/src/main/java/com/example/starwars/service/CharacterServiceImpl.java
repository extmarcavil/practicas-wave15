package com.example.starwars.service;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.model.Character;
import com.example.starwars.repositories.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterServiceImpl implements CharacterService{

    private final CharacterRepository repository;

    public CharacterServiceImpl(CharacterRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CharacterDTO> findAllByNameContains(String query) {

        List<Character> listaCaracteres = repository.findAllByNameContains(query);
        return listaCaracteres.stream()
                .map(character -> {
                    return new CharacterDTO(
                            character.getName(),
                            character.getGender(),
                            character.getHomeworld(),
                            character.getSpecies(),
                            character.getHeight(),
                            character.getMass());
                })
                .collect(Collectors.toList());
    }
}
