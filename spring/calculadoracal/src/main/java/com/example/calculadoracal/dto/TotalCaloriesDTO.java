package com.example.calculadoracal.dto;

import com.example.calculadoracal.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TotalCaloriesDTO {
    private double calories;
    private List<Ingredient> ingredients;
    private Ingredient mostCaloriesIngredient;
}
