package com.bootcamp.testing.repository.interfaces;

import com.bootcamp.testing.model.Ingredient;

import java.util.Optional;

public interface IStorehouseRepository {

    Optional<Ingredient> getIngredient(String name);
}
