package com.example.calculadoraCalorias.repository;

import com.example.calculadoraCalorias.dto.DtoIngrediente;
import com.example.calculadoraCalorias.modelo.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IngredientRepoImpl implements IngredientRepo {

    //hacer lista database
    List<DtoIngrediente> database;

    public IngredientRepoImpl(){
        database = new ArrayList<>();
        loadDataBase();
    }

    public List<DtoIngrediente> getIngredientes(){
        return database;
    }

    //llamar al Json

    private List<DtoIngrediente> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<DtoIngrediente>> typeRef = new TypeReference<>() {};
        List<DtoIngrediente> priceDTOS = null;
        try {
            priceDTOS = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return priceDTOS;
    }

}
