package com.company.model;

public class Transporte extends Reserva{

    public Transporte(double precio) {
        super(precio);
    }

    @Override
    public String toString() {
        return "Transporte{" +
                "precio=" + precio +
                '}';
    }
}
