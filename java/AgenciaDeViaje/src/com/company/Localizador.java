package com.company;

import java.util.List;
import java.util.Map;

public abstract class Localizador {
    protected Cliente cliente;
    protected double total;
    protected Map<int,String> reservas;

    public void obtenerTiposDeReserva(Map<int,String> reservas){
        reservas.put(1,"Hotel");
        reservas.put(2,"Comida");
        reservas.put(3,"Viaje");
        reservas.put(4,"Transporte");
    }

    public void generarReserva(List<int> seleccion){

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

    public Map<int, String> getReservas() {
        return reservas;
    }

    public void setReservas(Map<int, String> reservas) {
        this.reservas = reservas;
    }
}
