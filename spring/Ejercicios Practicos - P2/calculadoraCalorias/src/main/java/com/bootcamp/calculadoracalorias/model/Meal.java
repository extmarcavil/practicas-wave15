package com.bootcamp.calculadoracalorias.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Meal {
    private String name;
    List<Ingredient> ingredienteList;

    public Meal() {
    }

    public Meal(String name, List<Ingredient> ingredienteList) {
        this.name = name;
        this.ingredienteList = ingredienteList;
    }
}
