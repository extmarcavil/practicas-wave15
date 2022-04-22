package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.DTO.DishDTO;
import com.example.calculadoracalorias.DTO.DishResponseDTO;
import com.example.calculadoracalorias.model.Ingredient;

import java.util.List;

public interface ICalcService {

     DishResponseDTO calcDishCalories(DishDTO dishDTO);
     List<DishResponseDTO> calcAllDishesCalories(List<DishDTO> dishDTO);
     List<Ingredient> getIngredientsList();

}
