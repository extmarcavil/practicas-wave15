package com.bootcamp.testing.controller;

import com.bootcamp.testing.model.Recipe;
import com.bootcamp.testing.repository.interfaces.IRecipeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    IRecipeRepository recipeRepository;

    public RecipeController ( IRecipeRepository recipeRepository ) {
        this.recipeRepository = recipeRepository;
    }

    @PostMapping("")
    public ResponseEntity<Recipe> createRecipe( @RequestBody Recipe recipe){
        return new ResponseEntity<>(recipeRepository.createRecipe(recipe), HttpStatus.CREATED);
    }
}
