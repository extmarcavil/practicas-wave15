package com.example.starwars.repositories;

import com.example.starwars.model.CharacterStar;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.starwars.dto.CharacterDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {
  private final List<CharacterStar> database;

  public CharacterRepositoryImpl() {
    this.database = loadDataBase();
  }

  @Override
  public List<CharacterStar> findAllByNameContains(String query) {
    return database.stream()
        .filter(character -> matchWith(query, character))
        .collect(Collectors.toList());
  }

  private boolean matchWith(String query, CharacterStar character) {
    return character.getName().toUpperCase().contains(query.toUpperCase());
  }


  private List<CharacterStar> loadDataBase() {
    File file = null;
    try {
      file = ResourceUtils.getFile("classpath:starwars_characters.json");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    ObjectMapper objectMapper = new ObjectMapper();
    TypeReference<List<CharacterStar>> typeRef = new TypeReference<>() {};
    List<CharacterStar> characters = null;
    try {
      characters = objectMapper.readValue(file, typeRef);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return characters;
  }
}
