package com.vparula.calorias.model;

import java.util.List;

public class Plato {

    String nombre;
    int gramos;
    List<Ingrediente> ingredientes;


    public Plato(String nombre, int gramos, List<Ingrediente> ingredientes) {
        this.nombre = nombre;
        this.gramos = gramos;
        this.ingredientes = ingredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGramos() {
        return gramos;
    }

    public void setGramos(int gramos) {
        this.gramos = gramos;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
