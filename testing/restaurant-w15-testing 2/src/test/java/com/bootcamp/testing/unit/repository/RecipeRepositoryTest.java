package com.bootcamp.testing.unit.repository;

import com.bootcamp.testing.model.Ingredient;
import com.bootcamp.testing.model.Recipe;
import com.bootcamp.testing.repository.RecipeRepository;
import com.bootcamp.testing.repository.interfaces.IRecipeRepository;
import com.bootcamp.testing.utils.RecipeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class RecipeRepositoryTest {

    IRecipeRepository repository;

    @BeforeEach
    void setup(){
        repository = new RecipeRepository();
    }

    @Test
    @DisplayName(" encontramos la receta si pasamos un nombre valido")
    void findRecipeWithCorrectName(){
        // arrange
        String recipeName = "pizza";

        Recipe expected = RecipeFactory.createPizza();

        // act
        Optional<Recipe> result = repository.getRecipe(recipeName);

        // assert
        Assertions.assertEquals(expected, result.get());
    }

    @Test
    @DisplayName(" no encontramos la receta si pasamos un nombre invalido")
    void notFoundRecipeWithCorrectName(){
        // arrange
        String recipeName = "NOT_FOUND";

        // act
        Optional<Recipe> result = repository.getRecipe(recipeName);

        // assert
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName(" no encontramos la receta si pasamos un nombre invalido")
    void notFoundRecipeWithCorrectNamea(){
        // arrange
        String recipeName = null;

        // act & assert
        Assertions.assertThrows(NullPointerException.class, () -> repository.getRecipe(recipeName));
    }

/*    @Test
    @DisplayName(" no encontramos la receta si pasamos un null")
    void notFoundRecipeWithNull(){
        // arrange
        String recipeName = null;

        // act
        Optional<Recipe> result = repository.getRecipe(recipeName);

        // assert
        Assertions.assertThrows(result.isEmpty());
    }*/
}
