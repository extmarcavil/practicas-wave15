package com.p1vivo.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.p1vivo.starwars.entity.Character;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {
    private final List<Character> database;

    public CharacterRepositoryImpl () {
        this.database = loadDataBase();
    }

    @Override
    public List<Character> findAllByNameContains (String query ) {
        List<Character> characters = database.stream()
                .filter(c -> c.getName().contains(query))
                .collect(Collectors.toList());

        return characters;
    }

    private List<Character> loadDataBase () {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper                      objectMapper = new ObjectMapper();
        TypeReference<List<Character>> typeRef      = new TypeReference<>() {
        };
        List<Character>                characters   = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
