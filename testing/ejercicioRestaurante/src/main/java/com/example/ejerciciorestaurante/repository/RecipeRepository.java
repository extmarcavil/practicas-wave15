package com.example.ejerciciorestaurante.repository;

import com.example.ejerciciorestaurante.model.Recipe;
import com.example.ejerciciorestaurante.repository.interfaces.IRecipeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RecipeRepository implements IRecipeRepository {

    List<Recipe> recipes;

    public RecipeRepository() {
        this.recipes = loadDatabase();
    }


    @Override
    public List<Recipe> getDishes() {
        return recipes;
    }


    @Override
    public Optional<Recipe> getRecipe(String name) {
        return recipes.stream()
                .filter(recipe -> recipe.hasSomeName(name))
                .findFirst();
    }




    private List<Recipe> loadDatabase() {
    }
}
