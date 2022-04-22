package com.bootcamp.calculadoracalorias.repository;

import com.bootcamp.calculadoracalorias.model.Ingredient;
import com.bootcamp.calculadoracalorias.model.Meal;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CalculadoraRepository implements ICalculadoraRepository {

    private final List<Ingredient> ingredients;
    private final List<Meal> mealList;


    public CalculadoraRepository() {
        this.ingredients = loadDataBase();
        this.mealList = loadPlatos();
    }

    private List<Meal> loadPlatos() {
        List<Meal> meals = new ArrayList<>();
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(getIngrediente("Acelgas"));
        ingredients.add(getIngrediente("Ajos"));
        ingredients.add(getIngrediente("Naranja"));
        ingredients.add(getIngrediente("Cebolla"));

        meals.add(new Meal("Tamal", ingredients));
        ingredients.clear();

        ingredients.add(getIngrediente("Berenjena"));
        ingredients.add(getIngrediente("Berros"));
        ingredients.add(getIngrediente("Calabaza"));

        meals.add(new Meal("Arroz con pollo", ingredients));

        return meals;
    }

    private Ingredient getIngrediente(String ingrediente){
        return ingredients.stream().filter(i -> i.getName().equals(ingrediente) ).findFirst().orElse(null);
    }


    private List<Ingredient> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<java.util.List<Ingredient>> typeRef = new TypeReference<>() {
        };
        List<Ingredient> ingredientes = null;
        try {
            ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientes;
    }

    @Override
    public Meal getMeal(String name) {
        return mealList.stream()
                .filter(i -> i.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Meal> getMeals() {
        return mealList;
    }
}
