package com.company.model;

public class Boleto extends Reserva{

    public Boleto(double precio) {
        super(precio);
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "precio=" + precio +
                '}';
    }
}
