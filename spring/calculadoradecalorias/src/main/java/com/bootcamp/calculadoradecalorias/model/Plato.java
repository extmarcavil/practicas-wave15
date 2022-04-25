package com.bootcamp.calculadoradecalorias.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Plato {
    private String name;
    List<Ingrediente> ingredienteList;

    public Plato() {
    }

    public Plato(String name, List<Ingrediente> ingredienteList) {
        this.name = name;
        this.ingredienteList = ingredienteList;
    }
}
