package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.DTO.DishDTO;
import com.example.calculadoracalorias.DTO.DishResponseDTO;
import com.example.calculadoracalorias.model.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CalcRepository implements ICalcRepository {

    private final List<Ingredient> data;

    public CalcRepository() {
        data = loadData();
    }

    private List<Ingredient> loadData() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
        List<Ingredient> dataDTO = null;

        try {
            dataDTO = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataDTO;
    }

    public List<Ingredient> getAllIngredients() { return data; }

    @Override
    public Ingredient findIngredientByName(String name) {
        Optional<Ingredient> first = data.stream().filter(ingredient -> ingredient.getName().equals(name)).findFirst();
        Ingredient result = null;
        if (first.isPresent())
            result = first.get();
        return result;
    }

    @Override
    public void calculateIngredientCalories(Ingredient ingredient) {
        ingredient.setCalories(0);
        Ingredient ingredientFromRepository = this.findIngredientByName(ingredient.getName());
        if (ingredientFromRepository != null)
            ingredient.setCalories((int) (ingredient.getWeight() * ingredientFromRepository.getCalories() / 100.f));
    }

    @Override
    public DishResponseDTO calculateCalories(DishDTO dish) {
        DishResponseDTO response = new DishResponseDTO(dish);
        int total = 0;
        int maxCalories = 0;
        for (Ingredient ingredient : response.getIngredients()) {
            calculateIngredientCalories(ingredient);
            total += ingredient.getCalories();
            if (ingredient.getCalories() > maxCalories) {
                response.setCaloric(ingredient);
                maxCalories = ingredient.getCalories();
            }
        }
        response.setCalories(total);
        return response;
    }

    @Override
    public List<DishResponseDTO> calculateAllCalories(List<DishDTO> dishes) {
        List<DishResponseDTO> result = new ArrayList<>();
        for (DishDTO dish : dishes) {
            result.add(this.calculateCalories(dish));
        }
        return result;
    }
}
