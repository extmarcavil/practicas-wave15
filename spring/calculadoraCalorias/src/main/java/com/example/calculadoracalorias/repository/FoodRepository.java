package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.dto.IngredientDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class FoodRepository implements IFoodRepository {

    private List<IngredientDTO> ingredients;

    public FoodRepository() {
        this.ingredients = this.loadDataBase();
    }

    public IngredientDTO findIngredientByName(String name){
        return ingredients.stream().filter(v -> v.getName().equals(name)).findFirst().get();
    }

    public List<IngredientCaloriesDTO> getListIngredientsWithCalories(DishDTO dish){
        dish.getIngredients().stream()
                .map(v -> new IngredientDTO(v.getName()))
        return dish.getIngredients().stream()
                .map(ingredient -> this.getIngredientCalories(ingredient));
    }

    private IngredientCaloriesDTO getIngredientCalories(IngredientDTO ingredient){

    }

    private List<IngredientDTO> loadDataBase () {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:ingredients.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredientDTO>> typeRef = new TypeReference<>(){};
        List<IngredientDTO> ingredient = null;
        try {
            ingredient = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredient;
    }
}
