package com.example.starwars.repositories;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.dto.response.CharacterResponseDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepositoryImpl implements ICharacterRepository {
    private final List<CharacterDTO> database;

    public CharacterRepositoryImpl () {
        this.database = loadDataBase();
    }

    @Override
    public List<CharacterDTO> findAllByNameContains ( String query ) {
        return this.database.stream()
                .filter(c -> c.getName().contains(query))
                .collect(Collectors.toList());
    }
    public CharacterDTO findByName (String name ) {
        return this.database.stream()
                .filter(c -> c.getName().contains(name))
                .findFirst()
                .orElseGet(CharacterDTO::new);
    }

    private List<CharacterDTO> loadDataBase () {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper                      objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeRef      = new TypeReference<>() {
        };
        List<CharacterDTO>                characters   = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
