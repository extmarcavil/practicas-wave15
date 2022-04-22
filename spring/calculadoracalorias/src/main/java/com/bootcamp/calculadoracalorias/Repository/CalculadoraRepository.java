package com.bootcamp.calculadoracalorias.Repository;

import com.bootcamp.calculadoracalorias.DTO.IngredientesDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class CalculadoraRepository implements ICalculadoraRepository{
    private final List<IngredientesDTO> database;

    public CalculadoraRepository() { this.database = loadDataBase(); }

    private List<IngredientesDTO> loadDataBase () {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredientesDTO>> typeRef      = new TypeReference<>() {
        };
        List<IngredientesDTO>                ingredientes   = null;
        try {
            ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientes;
    }

    @Override
    public Optional<IngredientesDTO> ingredientesDto(String query) {
        return database.stream().filter(s -> s.getNombre().equals(query)).findFirst();
    }
}
