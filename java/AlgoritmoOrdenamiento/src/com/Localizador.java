package com;

import java.util.ArrayList;

public class Localizador {
    ArrayList<Reserva> reservas = new ArrayList<>();
    Cliente cliente;
    double total;

    public Localizador(ArrayList<Reserva> reservas, Cliente cliente, double total) {
        this.reservas = reservas;
        this.cliente = cliente;
        this.total = total;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "reservas=" + reservas +
                ", cliente=" + cliente +
                ", total=" + total +
                '}';
    }


}
