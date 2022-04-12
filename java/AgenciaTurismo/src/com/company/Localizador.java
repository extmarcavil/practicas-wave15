package com.company;

import java.util.ArrayList;

public class Localizador {
    //private Cliente cliente;
    private ArrayList<Reserva> reservas;
    public double costo;

    public Localizador(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public ArrayList<Reserva> obtenerReservas() {
        return reservas;
    }
}
