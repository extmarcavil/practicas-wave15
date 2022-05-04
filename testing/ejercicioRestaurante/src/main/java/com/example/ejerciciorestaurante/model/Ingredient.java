package com.example.ejerciciorestaurante.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ingredient {
    String name;
    Double quantity;
    Double calories;

    public Double calcTotalCalories() {
        return quantity * calories / 100;
    }

    public double getQuality() {

    }
}
