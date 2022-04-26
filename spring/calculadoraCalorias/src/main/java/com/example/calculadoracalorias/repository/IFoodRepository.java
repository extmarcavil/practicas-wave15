package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.dto.DishDTO;
import com.example.calculadoracalorias.dto.IngredientDTO;

import java.util.List;

public interface IFoodRepository {
    IngredientDTO findIngredientByName(String name);

    int getTotalCalories();

    IngredientDTO getMaxCalories();

    List<IngredientDTO> getIngredients();
}
