package com.calculadoradecalorias.calculadoradecalorias.repository;

import com.calculadoradecalorias.calculadoradecalorias.model.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IIngredientsRepository {

    List<Ingredient> returnDataBase();
    Optional<Ingredient> findByName(String name);
}
