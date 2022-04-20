package com.company.model.paqueteTuristico;

import com.company.model.Cliente;

public class Reserva {
    private static int contador;
    private int idReserva;
    private double monto;
    private Cliente cliente;

    public Reserva(Cliente cliente, double monto) {
        this.idReserva = ++this.contador;
        this.cliente = cliente;
        this.monto = monto;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Datos de la Reserva: " + "\n" +
                "idReserva=" + idReserva + "\n" +
                ", monto=" + monto + "\n" +
                ", cliente=" + cliente + "\n";
    }
}
