package com.calculadoradecalorias.calculadoradecalorias.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Food {
    private String name;
    private double weight;
    private List<Ingredient> listIngredients;
}
