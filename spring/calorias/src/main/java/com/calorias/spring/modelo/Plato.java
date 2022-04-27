package com.calorias.spring.modelo;

import java.util.List;

public class Plato {

    private String name;
    private int calorias;
    private List<Ingrediente> ingredientes;

    public Plato(int calorias, List<Ingrediente> ingredientes) {
        this.calorias = calorias;
        this.ingredientes = ingredientes;
    }



}
