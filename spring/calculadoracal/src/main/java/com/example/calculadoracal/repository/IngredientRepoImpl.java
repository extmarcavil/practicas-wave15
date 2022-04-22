package com.example.calculadoracal.repository;

import com.example.calculadoracal.model.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class IngredientRepoImpl implements IIngredientRepo {
    private final List<Ingredient> database;

    public IngredientRepoImpl () {
        this.database = loadDataBase();
    }

    private List<Ingredient> loadDataBase () {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {
        };
        List<Ingredient> ingredients   = null;
        try {
            ingredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredients;
    }

    @Override
    public List<Ingredient> findAll() {
        return database;
    }

    @Override
    public Ingredient findByName(String name) {
        return database.stream().filter(i -> i.getName().equalsIgnoreCase(name)).findFirst().get();
    }
}
