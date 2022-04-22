package com.example.starwars.repositories;

import com.example.starwars.dto.CharacterDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class CharacterRepository implements ICharacterRepository {
    private final List<CharacterDTO> database;

    public CharacterRepository() {
        this.database = loadDataBase();
    }

    @Override
    public List<CharacterDTO> findAllByNameContains ( String query ) {
        return this.database;
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
