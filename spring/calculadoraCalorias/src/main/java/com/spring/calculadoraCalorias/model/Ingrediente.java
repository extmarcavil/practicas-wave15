package com.spring.calculadoraCalorias.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ingrediente {

    private String name;
    private double calories;

    public Ingrediente(String name, double calories) {
        this.name = name;
        this.calories = calories;
    }

    public Ingrediente() {
    }
}
