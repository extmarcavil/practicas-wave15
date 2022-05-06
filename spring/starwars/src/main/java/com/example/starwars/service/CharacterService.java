package com.example.starwars.service;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.repositories.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService implements ICharacterService {

    /**
     * Injection by Constructor
     */
    private CharacterRepository repository;

    public CharacterService(CharacterRepository repository) {
        this.repository = repository;
    }

    /**
     * Metodos Impl
     *
     * @return
     */
    @Override
    public List<CharacterDTO> listar() {
        List<CharacterDTO> characterDto = repository.findAll().stream()
                .map(character -> new CharacterDTO(character.getName(), character.getGender(), character.getHomeworld(),
                        character.getSpecies(), character.getHeight(), character.getMass()))
                .collect(Collectors.toList());

        return characterDto;
    }

    @Override
    public List<CharacterDTO> listarPorNombre(String query) {
        List<CharacterDTO> charDtoResponse = repository.findAllByNameContains(query).stream()
                .map(character -> new CharacterDTO(character.getName(), character.getGender(), character.getHomeworld(),
                        character.getSpecies(), character.getHeight(), character.getMass()))
                .collect(Collectors.toList());

        return charDtoResponse;
    }
}
