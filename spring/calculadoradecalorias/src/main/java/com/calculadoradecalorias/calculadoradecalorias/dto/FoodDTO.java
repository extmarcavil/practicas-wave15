package com.calculadoradecalorias.calculadoradecalorias.dto;

import com.calculadoradecalorias.calculadoradecalorias.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {
    private double totalCalories;
    private List<IngredientDTO> ingredients;
    private IngredientDTO themostCaloriesIngredient;
}
