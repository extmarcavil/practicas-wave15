package com.calculadoradecalorias.calculadoradecalorias.dto;

import com.calculadoradecalorias.calculadoradecalorias.model.Ingredient;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class FoodDTO {
    private double calories;
    private List<Ingredient> ingredients;
    private Ingredient themosCalories;
}
