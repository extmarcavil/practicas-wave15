package ar.com.alehenestroza.apicalculadoracalorias.services;

import ar.com.alehenestroza.apicalculadoracalorias.models.Ingredient;

import java.util.List;

public interface FoodService {
    Integer getCalories(String name);
    List<Ingredient> getIngredients(String name);
    Ingredient getMostCaloricIngredient(String name);
}
