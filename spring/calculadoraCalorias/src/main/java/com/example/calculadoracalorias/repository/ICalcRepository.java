package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.DTO.DishDTO;
import com.example.calculadoracalorias.DTO.DishResponseDTO;
import com.example.calculadoracalorias.model.Ingredient;

import java.util.List;

public interface ICalcRepository {

    Ingredient findIngredientByName(String name);

    void calculateIngredientCalories(Ingredient ingredient);

    DishResponseDTO calculateCalories(DishDTO dish);

    List<DishResponseDTO> calculateAllCalories(List<DishDTO> dishes);

}
