package com.mercadolibre.starwars.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Data
public class CharacterRepositoryImpl implements CharacterRepository {
  private final List<CharacterDTO> database;

  public CharacterRepositoryImpl() {
    this.database = loadDataBase();
  }

  @Override
  public List<CharacterDTO> findAllByNameContains(String query) {
    return database.stream()
        .filter(characterDTO -> matchWith(query, characterDTO))
        .collect(Collectors.toList());
  }

  private boolean matchWith(String query, CharacterDTO characterDTO) {
    return characterDTO.getName().toUpperCase().contains(query.toUpperCase());
  }


  private List<CharacterDTO> loadDataBase() {
    File file = null;
    try {
      file = ResourceUtils.getFile("classpath:starwars_characters.json");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    ObjectMapper objectMapper = new ObjectMapper();
    TypeReference<List<CharacterDTO>> typeRef = new TypeReference<>() {};
    List<CharacterDTO> characters = null;
    try {
      characters = objectMapper.readValue(file, typeRef);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return characters;
  }
}
