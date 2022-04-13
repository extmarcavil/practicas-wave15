package com.company.vehiculos;

public abstract class Vehiculo {
   private double velocidad, aceleracion, peso;
   private int angulogiro, ruedas;
   private String patente;

    public Vehiculo(double velocidad, double aceleracion, int angulogiro, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.angulogiro = angulogiro;
        this.patente = patente;
    }

    public Vehiculo(String patente) {
        this.patente = patente;
    }

    public double ObtenerValor(){
        return velocidad*aceleracion/2 /(angulogiro*(peso- ruedas));
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getAngulogiro() {
        return angulogiro;
    }

    public void setAngulogiro(int angulogiro) {
        this.angulogiro = angulogiro;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }
}
