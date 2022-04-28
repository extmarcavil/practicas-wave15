package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.dto.IngredientDTO;

public interface IFoodRepository {
    IngredientDTO findIngredientByName(String name);
}
