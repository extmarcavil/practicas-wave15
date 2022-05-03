package com.bootcamp.testing.service;

import com.bootcamp.testing.model.Ingredient;
import com.bootcamp.testing.model.Recipe;
import com.bootcamp.testing.exception.notfound.IngredientNotFoundException;
import com.bootcamp.testing.exception.notfound.RecipeNotFoundException;
import com.bootcamp.testing.repository.interfaces.IRecipeRepository;
import com.bootcamp.testing.repository.interfaces.IStorehouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KitchenService implements IKitchenService {
    IRecipeRepository     recipeRepository;
    IStorehouseRepository storehouseRepository;

    public KitchenService ( IRecipeRepository recipeRepository, IStorehouseRepository storehouseRepository ) {
        this.recipeRepository     = recipeRepository;
        this.storehouseRepository = storehouseRepository;
    }

    @Override
    public List<Recipe> getDishes () {
        return recipeRepository.getRecipes();
    }

    @Override
    public Recipe createDish ( String name ) {

        Optional<Recipe> optionalRecipe = recipeRepository.getRecipe(name); // () -> Optional.of(new Recipe());
                                                                            // () -> Optional.empty()
        Recipe           recipe         = optionalRecipe.orElseThrow(() -> new RecipeNotFoundException(name));

        this.updateIngredientsOf(recipe);

        Double quality = this.getQualityOf(recipe);

        Double calories = this.getTotalCaloriesOf(recipe);

        recipe.setQuality(quality);
        recipe.setCalories(calories);

        return recipe;
    }

    private void updateIngredientsOf ( Recipe recipe ) {
        List<Ingredient> ingredients = recipe.getIngredients()
          .stream()
          .map(ing -> {
                String               name               = ing.getName();
                Optional<Ingredient> optionalIngredient = storehouseRepository.getIngredient(name); // () -> Optional.of(new Ingredient())
                Ingredient           ingredient         = optionalIngredient.orElseThrow(() -> new IngredientNotFoundException(name));
                ingredient.setQuantity(ing.getQuantity());
                return ingredient;
            }
          )
          .collect(Collectors.toList());

        recipe.setIngredients(ingredients);
    }


    private double getTotalCaloriesOf ( Recipe recipe ) {
        Double           totalCalories = 0D;
        List<Ingredient> ingredients   = recipe.getIngredients();

        for (int i = 0; i < ingredients.size(); i++) {
            Ingredient ingredient = ingredients.get(i);
            totalCalories += ingredient.calcTotalCalories();
        }

        return totalCalories;
        /*
            return recipe.getIngredients()
              .stream()
              .mapToDouble(Ingredient::calcTotalCalories)
              .sum();
        */
    }

    private double getQualityOf ( Recipe recipe ) {
        Double           totalQuality = 0D;
        List<Ingredient> ingredients  = recipe.getIngredients();

        for (int i = 0; i < ingredients.size(); i++) {
            Ingredient ingredient = ingredients.get(i);
            totalQuality += ingredient.getQuality();
        }

        if (!totalQuality.equals(0D)) {
            totalQuality = totalQuality / ingredients.size();
        }

        return totalQuality;
        /*
            return recipe.getIngredients()
              .stream()
              .mapToDouble(Ingredient::getQuality)
              .average()
              .orElse(0D);
        */
    }

}
