package com.muchut.dakar;

public class Motos extends Vehiculo{
    public Motos(int velocidad, int aceleracion, int anguloDeGiro, int peso, int ruedas, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, peso, ruedas, patente);
        this.peso = 300;
        this.ruedas = 2;
    }
}
