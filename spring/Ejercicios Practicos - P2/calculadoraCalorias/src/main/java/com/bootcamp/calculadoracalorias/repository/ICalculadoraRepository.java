package com.bootcamp.calculadoracalorias.repository;

import com.bootcamp.calculadoracalorias.model.Meal;

import java.util.List;

public interface ICalculadoraRepository {
    Meal getMeal(String name);
    List<Meal> getMeals();
}
