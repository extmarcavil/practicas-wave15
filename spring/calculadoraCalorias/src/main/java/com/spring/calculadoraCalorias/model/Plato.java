package com.spring.calculadoraCalorias.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Plato {

    private String nombre;
    private List<Ingrediente> ingredientes;
    private double peso;

    public Plato(String nombre, List<Ingrediente> ingredientes, double peso) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.peso = peso;
    }
}
