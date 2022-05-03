package com.bootcamp.testing.utils;

import com.bootcamp.testing.model.Ingredient;
import com.bootcamp.testing.model.Recipe;

import java.util.Arrays;
import java.util.List;

public class RecipeFactory {

    public static Recipe createPizza(){
        Ingredient tomato = IngredientFactory.getTomaco();

        Ingredient bread = IngredientFactory.getBread();

        List<Ingredient> ingredients = Arrays.asList(tomato, bread);

        Recipe expected = new Recipe();
        expected.setName("pizza");
        expected.setDescription("lorem ipsum");
        expected.setIngredients(ingredients);

        return expected;
    }
}
