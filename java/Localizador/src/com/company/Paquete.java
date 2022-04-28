package com.company;

import java.util.ArrayList;

public class Paquete {

    private ArrayList<Comida> comida;
    private ArrayList<Boleto> boleto;
    private ArrayList<ReservaHotel> reserva;
    private Transporte transporte;

    public Paquete() {
        comida = new ArrayList<>();
        boleto = new ArrayList<>();
        reserva = new ArrayList<>();
    }

    public ArrayList<Comida> getComida() {
        return comida;
    }

    public void setComida(ArrayList<Comida> comida) {
        this.comida = comida;
    }

    public ArrayList<Boleto> getBoleto() {
        return boleto;
    }

    public void setBoleto(ArrayList<Boleto> boleto) {
        this.boleto = boleto;
    }

    public ArrayList<ReservaHotel> getReserva() {
        return reserva;
    }

    public void setReserva(ArrayList<ReservaHotel> reserva) {
        this.reserva = reserva;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }
}
