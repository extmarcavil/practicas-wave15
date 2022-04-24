package com.calculadoradecalorias.calculadoradecalorias.repository;

import com.calculadoradecalorias.calculadoradecalorias.model.Food;
import com.calculadoradecalorias.calculadoradecalorias.model.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IFoodRepo {
    void createFood(String name, double weight, List<Ingredient> listIngredients);
    Optional<Food> findByName(String name);
    List<Food> getDatabase();
}
