package com.spring.calculadoraDeCaloria.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Ingredient {
    private String name;
    private int calories;

    public Ingredient ( String name ) {
        this.name = name;
    }

    public boolean hasName ( String name ) {
        return this.name.equals(name);
    }
}
