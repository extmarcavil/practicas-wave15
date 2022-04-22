package com.bootcamp.calculadoracalorias.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ingredient {
    private String name;
    private Integer calories;

    public Ingredient() {
    }
}
