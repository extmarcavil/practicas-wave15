package com.example.ejerciciorestaurante.service;

import com.example.ejerciciorestaurante.exception.RecipeNotFoundException;
import com.example.ejerciciorestaurante.model.Ingredient;
import com.example.ejerciciorestaurante.model.Recipe;
import com.example.ejerciciorestaurante.repository.interfaces.IRecipeRepository;
import com.example.ejerciciorestaurante.repository.interfaces.IStorehouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KitchenService implements IKitchenService {

    IRecipeRepository recipeRepo;
    IStorehouseRepository storeRepo;

    public KitchenService(IRecipeRepository recipeRepo, IStorehouseRepository storeRepo) {
        this.recipeRepo = recipeRepo;
        this.storeRepo = storeRepo;
    }

    @Override
    public List<Recipe> getDishes() {
        return recipeRepo.getDishes();
    }

    @Override
    public Recipe createDish(String name) {
        Optional<Recipe> opcRecipe = recipeRepo.getRecipe(name);
        Recipe recipe = opcRecipe.orElseThrow(() -> new RecipeNotFoundException(name));

        this.updateIngredientsOf(recipe);

        Double quality = this.getQualityOf(recipe);
        Double calories = this.getTotalCaloriesOf(recipe);

        recipe.setQuality(quality);
        recipe.setCalories(calories);

        return recipe;
    }

    private Double getQualityOf(Recipe recipe) {
        return recipe.getIngredients()
                .stream()
                .mapToDouble(Ingredient::getQuality)
                .average()
                .orElse(0D);
    }

    private Double getTotalCaloriesOf(Recipe recipe) {
        return recipe.getIngredients()
                .stream()
                .mapToDouble(Ingredient::calcTotalCalories)
                .sum();
    }

    private void updateIngredientsOf(Recipe recipe) {
        List<Ingredient> ingredients = recipe.getIngredients()
                .stream()
                .map(ingredient -> {
                    String name = ingredient.getName();
                    Optional<Ingredient> optIngredient = storeRepo.getIngredient(name);
                    Ingredient ingredientFound = optIngredient.orElseThrow(() -> IngredientNotFoundException(name));
                    ingredientFound.setQuantity(ingredient.getQuantity());
                    return ingredientFound;
                })
                .collect(Collectors.toList());
        recipe.setIngredients(ingredients);
    }
}
