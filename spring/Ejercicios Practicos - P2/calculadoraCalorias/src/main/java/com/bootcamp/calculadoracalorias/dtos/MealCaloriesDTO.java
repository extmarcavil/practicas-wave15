package com.bootcamp.calculadoracalorias.dtos;

import com.bootcamp.calculadoracalorias.model.Ingredient;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MealCaloriesDTO {
    private Integer calories;
    private List<Ingredient> ingredientList;
    private String ingredienteMayorCal;

    public MealCaloriesDTO(){
    }

    public MealCaloriesDTO(Integer calories, List<Ingredient> ingredienteList, String ingredienteMayorCal) {
        this.calories = calories;
        this.ingredientList = ingredienteList;
        this.ingredienteMayorCal = ingredienteMayorCal;
    }
}
