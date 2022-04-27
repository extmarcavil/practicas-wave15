package com.calculadoradecalorias.calculadoradecalorias.repository;

import com.calculadoradecalorias.calculadoradecalorias.model.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Getter
@Repository
public class IngredientsRepository implements IIngredientsRepository{

    List<Ingredient> database;

    public IngredientsRepository() {
        database = loadDataBase();
    }

    @Override
    public List<Ingredient> returnDataBase(){
        return database;
    }

    @Override
    public Optional<Ingredient> findByName(String name) {
        return database
                .stream()
                .filter(i -> i.getName().equals(name))
                .findFirst();
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




}
