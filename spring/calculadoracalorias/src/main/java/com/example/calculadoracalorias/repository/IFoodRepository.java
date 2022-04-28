package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.DTO.DishesDTO;
import com.example.calculadoracalorias.DTO.IngredientsDTO;

import java.util.List;

public interface IFoodRepository {
    int getTotalCalories(DishesDTO dish);
    List<IngredientsDTO> getIngredients(DishesDTO dish);
    IngredientsDTO getMaxCalIngredient(DishesDTO dish);

}
