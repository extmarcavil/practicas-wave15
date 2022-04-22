package com.mercadolibre.calculadoracalorias.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ingredient {
    private String name;
    private Double calories;

    public Ingredient ( String name ) {
        this.name = name;
    }

    public boolean hasName ( String name ) {
        return this.name.equals(name);
    }
}
