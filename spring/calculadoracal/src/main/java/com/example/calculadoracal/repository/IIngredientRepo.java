package com.example.calculadoracal.repository;

import com.example.calculadoracal.model.Ingredient;

import java.util.List;

public interface IIngredientRepo {
    List<Ingredient> findAll();
    Ingredient findByName(String name);
}
