package com.company.model;

import com.company.model.paqueteTuristico.Reserva;
import java.util.ArrayList;

public class Localizador {
    private Cliente cliente;
    private double montoTotal;
    private ArrayList<Reserva> listaReservas;

    public Localizador(Cliente cliente, ArrayList<Reserva> listaReservas) {
        this.cliente = cliente;
        this.listaReservas = listaReservas;
        this.montoTotal = getMontoTotal();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getMontoTotal() {
        montoTotal = 0;

        for(Reserva reserva : listaReservas){
            montoTotal = montoTotal + reserva.getMonto();
        }
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    @Override
    public String toString() {
        return "* Datos del Localizador = \n" +
                "  Datos del Cliente: " + cliente + "\n" +
                "  Monto Total a Pagar: $" + montoTotal + "\n" +
                "  Lista de Reservas : " + listaReservas.toString() + "\n" ;
    }
}
