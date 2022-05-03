package com.bootcamp.testing.repository.interfaces;

import com.bootcamp.testing.model.Recipe;

import java.util.List;
import java.util.Optional;

public interface IRecipeRepository {

    List<Recipe> getRecipes();

    Optional<Recipe> getRecipe(String name);

    Recipe createRecipe(Recipe recipe);
}
