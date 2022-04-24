package com.calculadoradecalorias.calculadoradecalorias.service;

import com.calculadoradecalorias.calculadoradecalorias.dto.FoodDTO;
import com.calculadoradecalorias.calculadoradecalorias.dto.IngredientDTO;

import java.util.List;

public interface IFoodService {
    FoodDTO findFood(String name);
    double totalCaloriesFood(String name, double peso);
    List<IngredientDTO> listIngredients (String name);
    IngredientDTO mostCaolires(String name);
}
