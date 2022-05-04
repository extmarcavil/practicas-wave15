package com.company.model;

public class ReservaHotel extends Reserva{

    public ReservaHotel(double precio) {
        super(precio);
    }

    @Override
    public String toString() {
        return "ReservaHotel{" +
                "precio=" + precio +
                '}';
    }
}
