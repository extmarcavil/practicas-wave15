package com.company.model;

public abstract class Reserva {
    protected double precio;

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Reserva(double precio) {
        this.precio = precio;
    }

}
