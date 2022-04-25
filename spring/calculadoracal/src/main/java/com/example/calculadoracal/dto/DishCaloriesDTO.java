package com.example.calculadoracal.dto;

import com.example.calculadoracal.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DishCaloriesDTO {
    private double calories;
    private List<IngredientDTO> ingredients;
    private IngredientDTO mostCaloriesIngredient;
}
