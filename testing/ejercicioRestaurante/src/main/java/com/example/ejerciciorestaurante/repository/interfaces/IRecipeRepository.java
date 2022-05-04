package com.example.ejerciciorestaurante.repository.interfaces;

import com.example.ejerciciorestaurante.model.Recipe;

import java.util.List;
import java.util.Optional;

public interface IRecipeRepository {
    List<Recipe> getDishes();

    Optional<Recipe> getRecipe(String name);
}
