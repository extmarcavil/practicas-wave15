package com.mercadolibre.calculadoracalorias.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadoracalorias.dto.IngredientDTO;
import com.mercadolibre.calculadoracalorias.model.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository {
  private List<Ingredient> database;

  public IngredientRepositoryImpl() {
    database = loadDataBase();
  }

  @Override
  public Optional<Ingredient> findIngredientByName( String name) {
    return database.stream()
      .filter(ingredient -> ingredient.hasName(name))
      .findFirst();
  }

  private List<Ingredient> loadDataBase() {
    File file = null;
    try {
      file = ResourceUtils.getFile("classpath:food.json");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    ObjectMapper objectMapper = new ObjectMapper();
    TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
    List<Ingredient> priceDTOS = null;
    try {
      priceDTOS = objectMapper.readValue(file, typeRef);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return priceDTOS;
  }
}
