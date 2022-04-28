package com.example.calculadoracalorias.dto.response;

import com.example.calculadoracalorias.dto.DishDTO;
import com.example.calculadoracalorias.dto.IngredientDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CaloriesResponseDTO {
    private int totalCalories;
    private List<IngredientDTO> ingredients;
    private IngredientDTO ingredientMaxCalories;

    public CaloriesResponseDTO(DishDTO dish) {
        this.setIngredients(dish.getIngredients());
    }
}
