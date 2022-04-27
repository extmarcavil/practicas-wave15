package com.calorias.spring.modelo;

import java.util.List;

public class PlatoDTO {

    private int calorias;
    private List<Ingrediente> ingredientes;
    private Ingrediente calorico;

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Ingrediente getCalorico() {
        return calorico;
    }

    public void setCalorico(Ingrediente calorico) {
        this.calorico = calorico;
    }
}
