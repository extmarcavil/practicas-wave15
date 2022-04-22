package com.mercadolibre.calculadoracalorias.model;

import com.mercadolibre.calculadoracalorias.dto.IngredientDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Dish {
    private String           name;
    private List<Ingredient> ingredients;
}
