package com.company;

import java.util.Objects;

public class Vehiculo implements Comparable {

    private String modelo;
    private String marca;
    private double costo;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, double costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    /**
     * Metodo CompareTo para comparar este Objeto Vehiculo y poder ordenarlo.
     *
     * @param o
     * @return
     */

    @Override
    public int compareTo(Object o) {
        Vehiculo v2 = (Vehiculo) o;
        int respuesta = 0;

        if (this.getCosto() > v2.getCosto()) {
            respuesta = 1;
        }
        if (this.getCosto() < v2.getCosto()) {
            respuesta = -1;
        }
        return respuesta;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", costo=" + costo +
                '}';
    }
}
