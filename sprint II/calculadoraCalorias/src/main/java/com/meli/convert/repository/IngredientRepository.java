package com.meli.convert.repository;

import com.meli.convert.model.Ingredient;

public interface IngredientRepository {

    Ingredient getIngredient(String name);
}
