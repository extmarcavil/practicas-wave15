package com.example.calculadoracal.dto;

import com.example.calculadoracal.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodInfoDTO {
    private double calories;
    private List<Ingredient> ingredients;
    private Ingredient mostCaloriesIngredient;
}
