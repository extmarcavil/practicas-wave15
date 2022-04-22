package com.example.starwars.repository;

import com.example.starwars.model.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StarWarsRepository implements IStarWarsRepository {

    private List<Character> dataBase;

    public StarWarsRepository() {
        this.dataBase = this.loadDataBase();
    }

    @Override
    public List<Character> findAllByNameContains(String query) {
        // Filtrar los datos por nombre.
        return dataBase.stream()
                .filter(v -> v.containsQuery(query))
                .collect(Collectors.toList());
    }

    private List<Character> loadDataBase () {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Character>> typeRef = new TypeReference<>(){};
        List<Character> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
