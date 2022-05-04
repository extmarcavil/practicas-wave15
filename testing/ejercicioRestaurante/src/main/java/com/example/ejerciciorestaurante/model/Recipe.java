package com.example.ejerciciorestaurante.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Recipe {

    List<Ingredient> ingredients;
    Double quality;
    Double calories;

    public boolean hasSomeName(String name) {
        return ingredients.stream()
                .anyMatch(ingredient -> ingredient.getName().equals(name));
    }
}
