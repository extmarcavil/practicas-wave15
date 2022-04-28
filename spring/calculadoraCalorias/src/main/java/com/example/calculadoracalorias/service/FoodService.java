package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.DishDTO;
import com.example.calculadoracalorias.dto.IngredientDTO;
import com.example.calculadoracalorias.dto.response.CaloriesResponseDTO;
import com.example.calculadoracalorias.repository.IFoodRepository;
import org.springframework.stereotype.Service;

@Service
public class FoodService implements IFoodService {

    private final IFoodRepository repository;

    public FoodService(IFoodRepository repository) {
        this.repository = repository;
    }

    @Override
    public CaloriesResponseDTO getCalories(DishDTO dish) {
        CaloriesResponseDTO response = new CaloriesResponseDTO(dish);
        int total = 0;
        int max = 0;
        for (IngredientDTO ingredient : response.getIngredients()) {
            // Calculate de total calories for every ingredient.
            calculateTotalCaloriesForIngredient(ingredient);
            total += ingredient.getCalories();
            max = getMax(response, max, ingredient);
        }
        // Set the total of calories.
        response.setTotalCalories(total);
        return response;
    }

    private void calculateTotalCaloriesForIngredient(IngredientDTO ingredient) {
        // Set value to 0 if it is not present in the database.
        ingredient.setCalories(0);
        IngredientDTO ingredientData = repository.findIngredientByName(ingredient.getName());
        if (ingredientData != null) {
            // Save total calories.
            ingredient.setCalories(getTotalCaloriesForIngredient(ingredient, ingredientData));
        }
    }

    private int getTotalCaloriesForIngredient(IngredientDTO ingredient, IngredientDTO ingredientData) {
        // Calculate total calories of an ingredient.
        return ingredient.getWeight() * ingredientData.getCalories() / 100;
    }

    private int getMax(CaloriesResponseDTO response, int max, IngredientDTO ingredient) {
        // Get de max value and set it to the response.
        if (ingredient.getCalories() > max) {
            response.setIngredientMaxCalories(ingredient);
            max = ingredient.getCalories();
        }
        return max;
    }
}
