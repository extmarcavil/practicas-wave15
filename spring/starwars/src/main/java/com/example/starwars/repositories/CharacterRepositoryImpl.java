package com.example.starwars.repositories;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.entities.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {

    /**
     * Injection by Constructor
     */
    private final List<Character> database;

    public CharacterRepositoryImpl() {
        this.database = new ArrayList<>();
    }

    /**
     * Metodos
     *
     * @return
     */
    @Override
    public List<Character> findAll() {
        return database;
    }

    @Override
    public List<Character> findAllByNameContains(String query) {

        List<Character> characterQuery = database.stream()
                .filter(character -> character.getName().contains(query))
                .collect(Collectors.toList());

        return characterQuery;
    }


    /**
     * Carga de BD
     *
     * @return
     */
    @PostConstruct
    private List<Character> loadDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Character>> typeRef = new TypeReference<>() {
        };

        List<Character> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //Cargando la base de datos
        database.addAll(characters);
        return characters;
    }
}
