package com.company;

import java.util.Locale;

public class Categoria {
    private String circuito;

    public Categoria(String circuito) {
        this.circuito = circuito;
    }

    public String getCircuito() {
        return circuito;
    }

    public void setCircuito(String circuito) {
        this.circuito = circuito;
    }

    @Override
    public String toString() {
        return "Circuito del participante: " + circuito + '\'' + '}';
    }

    public boolean verificoCategoria(String categoria){
        categoria.toLowerCase();
        return (categoria == "chico" || categoria == "medio" || categoria == "avanzado");
    }
}
