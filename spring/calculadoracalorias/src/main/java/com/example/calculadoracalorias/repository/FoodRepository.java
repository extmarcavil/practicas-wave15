package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.DTO.DishesDTO;
import com.example.calculadoracalorias.DTO.IngredientsDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class FoodRepository implements IFoodRepository{
    private List<IngredientsDTO> database;

    public void CharacterRepositoryImpl () {
        this.database = loadDataBase();
    }

    public List<IngredientsDTO> findAllByNameContains ( String query ) {
        return null;
    }

    private List<IngredientsDTO> loadDataBase () {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredientsDTO>> typeRef      = new TypeReference<>() {
        };
        List<IngredientsDTO>                ingredients   = null;
        try {
            ingredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredients;
    }

    @Override
    public int getTotalCalories(DishesDTO dish) {
        return 0;
    }

    @Override
    public List<IngredientsDTO> getIngredients(DishesDTO dish) {
        return null;
    }

    @Override
    public IngredientsDTO getMaxCalIngredient(DishesDTO dish) {
        return null;
    }
}
