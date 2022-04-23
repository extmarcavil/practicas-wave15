package com.starwar.starwarcharacters.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwar.starwarcharacters.dto.CharacterDTO;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.util.ResourceUtils;

@Repository
public class CharacterRepository {

    private final List<CharacterDTO> characters;

    public CharacterRepository() {
        characters = loadDataBase();
    }

    private List<CharacterDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeRef      = new TypeReference<>() {};
        List<CharacterDTO> characters   = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }

    public List<CharacterDTO> getCharacters() {
        return characters;
    }
}
