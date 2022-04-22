package com.bootcamp.calculadoracalorias.service;

import com.bootcamp.calculadoracalorias.dtos.MealCaloriesDTO;
import com.bootcamp.calculadoracalorias.dtos.MealDTO;

import java.util.List;

public interface ICalculadoraService {
    MealCaloriesDTO getMeal(String name, Integer peso);
    List<MealDTO> getMeals();
}
