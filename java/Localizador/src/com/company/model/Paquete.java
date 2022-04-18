package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Paquete {

    private List<Comida> comida;
    private List<Boleto> boleto;
    private List<ReservaHotel> reserva;
    private Transporte transporte;

    public Paquete() {
        comida = new ArrayList<>();
        boleto = new ArrayList<>();
        reserva = new ArrayList<>();
    }

    public List<Comida> getComida() {
        return comida;
    }

    public void setComida(ArrayList<Comida> comida) {
        this.comida = comida;
    }

    public List<Boleto> getBoleto() {
        return boleto;
    }

    public void setBoleto(ArrayList<Boleto> boleto) {
        this.boleto = boleto;
    }

    public List<ReservaHotel> getReserva() {
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

    public void addComida(Comida comida){
        this.comida.add(comida);
    }
    public void addBoleto(Boleto boleto){
        this.boleto.add(boleto);
    }
    public void addReserva(ReservaHotel reserva){
        this.reserva.add(reserva);
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "comida=" + comida +
                ", boleto=" + boleto +
                ", reserva=" + reserva +
                ", transporte=" + transporte +
                '}';
    }
}
