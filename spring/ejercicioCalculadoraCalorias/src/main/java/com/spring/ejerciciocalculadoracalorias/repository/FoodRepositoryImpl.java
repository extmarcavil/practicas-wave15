package com.spring.ejerciciocalculadoracalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.ejerciciocalculadoracalorias.dto.IngredienteDTO;
import com.spring.ejerciciocalculadoracalorias.model.Food;
import com.spring.ejerciciocalculadoracalorias.model.Ingrediente;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FoodRepositoryImpl implements FoodRepository{

    private final List<Ingrediente> database;

    public FoodRepositoryImpl() {
        this.database = this.loadDataBase();
    }

    /*
    @Override
    public List<Ingrediente> getAllFoods() {
        return database;
    }
    */

    @Override
    public Optional<Ingrediente> getIngredientByName(String name) {
        return  database.stream()
                .filter(ingrediente -> ingrediente.hasName(name))
                .findFirst();
    }


    private List<Ingrediente> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {
        };
        List<Ingrediente> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }


}
