package com.company.model;

public class Comida extends Reserva{

    public Comida(double precio) {
        super(precio);
    }

    @Override
    public String toString() {
        return "Comida{" +
                "precio=" + precio +
                '}';
    }
}
