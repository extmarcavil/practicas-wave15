package com.calorie.caloriecalculation.repository;

import com.calorie.caloriecalculation.model.Food;
import com.calorie.caloriecalculation.model.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class CaloriesCalculationRepository implements ICaloriesCalculationRepository {

    private List<Ingredient> ingredients;
    private final List<Food> foods;

    public CaloriesCalculationRepository() {
        foods = new ArrayList<>();
        loadIngredients();
    }

    private void loadIngredients() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<List<Ingredient>> typeRef = new TypeReference<>(){};

        try {
            ingredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }


        List<Ingredient> ingredientsFood1 = new ArrayList<>();

        Random r = new Random();
        int value;
        Ingredient ingredient;
        for (int i = 0; i < 3; i++){
            value = r.nextInt(ingredients.size()-1 + i) + i;
            ingredient = ingredients.get(value);
            ingredientsFood1.add(ingredient);
        }

        Food f1 = new Food("Fideos con tuco",200.5f, ingredientsFood1);
        foods.add(f1);

        List<Ingredient> ingredientsFood2 = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            value = r.nextInt(ingredients.size()-1 + i) + i;
            ingredient = ingredients.get(value);
            ingredientsFood2.add(ingredient);
        }

        Food f2 = new Food("empanada", 300.5f, ingredientsFood2);

        foods.add(f2);
    }

    @Override
    public Food findFood(String name, float weight) {
        return foods.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name) && p.getWeight() == weight)
                .findFirst()
                .orElse(null);
    }
}
