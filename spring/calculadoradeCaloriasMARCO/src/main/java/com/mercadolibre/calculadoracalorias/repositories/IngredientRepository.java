package com.mercadolibre.calculadoracalorias.repositories;

import com.mercadolibre.calculadoracalorias.model.Ingredient;

import java.util.Optional;

public interface IngredientRepository {
  Optional<Ingredient> findIngredientByName( String name);
}
