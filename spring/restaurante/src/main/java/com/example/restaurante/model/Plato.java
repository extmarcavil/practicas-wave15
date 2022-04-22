package com.example.restaurante.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Plato {
    private String name;
    private double peso;
    private ArrayList<Alimento> alimentos;

    public Plato(String name, double peso, ArrayList<Alimento> alimentos) {
        this.name = name;
        this.peso = peso;
        this.alimentos = alimentos;
    }
}
