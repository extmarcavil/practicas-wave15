package com.company.vehiculo;

public class Vehiculo {

    /**
     * Atributos de la clase.
     */
    private double velocidad;
    private double aceleracion;
    private String patente;
    private double anguloDeGiro;
    private double peso;
    private int ruedas;


    /**
     * Constructor.
     *
     * @param velocidad
     * @param aceleracion
     * @param patente
     * @param anguloDeGiro
     * @param peso
     * @param ruedas
     */
    public Vehiculo(double velocidad, double aceleracion, String patente, double anguloDeGiro, double peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.patente = patente;
        this.anguloDeGiro = anguloDeGiro;
        this.peso = peso;
        this.ruedas = ruedas;
    }


    /**
     * Getter & Setters
     */
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

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    /**
     * ToString
     */
    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", patente='" + patente + '\'' +
                ", anguloDeGiro=" + anguloDeGiro +
                ", peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }
}
