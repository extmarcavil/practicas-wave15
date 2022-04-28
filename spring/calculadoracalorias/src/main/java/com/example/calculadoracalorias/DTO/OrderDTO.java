package com.example.calculadoracalorias.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDTO {
    private int totalCalories;
    private List<IngredientsDTO> ingredientsList;
    private IngredientsDTO maximunCaloriesIngredient;
}
