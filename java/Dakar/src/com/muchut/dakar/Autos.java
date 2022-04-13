package com.muchut.dakar;

public class Autos extends Vehiculo{

    public Autos(int velocidad, int aceleracion, int anguloDeGiro, int peso, int ruedas, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, peso, ruedas, patente);
        this.peso = 1000;
        this.ruedas = 4;
    }

}
