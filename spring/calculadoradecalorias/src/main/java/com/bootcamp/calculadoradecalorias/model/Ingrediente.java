package com.bootcamp.calculadoradecalorias.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ingrediente {
    private String name;
    private Integer calories;

    public Ingrediente() {
    }
}
