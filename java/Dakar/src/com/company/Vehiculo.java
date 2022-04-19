package com.company;

import java.util.List;

public class Vehiculo {
    private Double velocidad;
    private double aceleracion;
    private double angDeGiro;
    private String patente;
    private double peso;
    private int rueda;

    public Vehiculo(Double velocidad, Double aceleracion, Double angDeGiro, String patente, int rueda, double peso) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.angDeGiro = angDeGiro;
        this.patente = patente;
        this.rueda = rueda;
        this.peso = peso;
    }


    public Double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public double getAngDeGiro() {
        return angDeGiro;
    }

    public void setAngDeGiro(double angDeGiro) {
        this.angDeGiro = angDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getRueda() {
        return rueda;
    }

    public void setRueda(int rueda) {
        this.rueda = rueda;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", angDeGiro=" + angDeGiro +
                ", patente='" + patente + '\'' +
                ", rueda=" + rueda +
                ", peso=" + peso +
                '}';
    }
}
