package ar.com.alehenestroza.apicalculadoracalorias.repositories;

import ar.com.alehenestroza.apicalculadoracalorias.models.Ingredient;

import java.util.List;

public interface FoodRepository {
    Integer getCalories(String name);
    List<Ingredient> getIngredients(String name);
    Ingredient getMostCaloricIngredient(String name);
}
