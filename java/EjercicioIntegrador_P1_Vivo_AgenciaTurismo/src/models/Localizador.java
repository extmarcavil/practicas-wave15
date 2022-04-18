package models;

import java.util.ArrayList;
import java.util.List;

public class Localizador {

     private Cliente cliente;
     private List<Reserva> reservas = new ArrayList<>();
     private double total;

    public Localizador() {
    }

    public Localizador(Cliente cliente, List<Reserva> reservas, double total) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.total = total;
    }

    public void agregarReserva (Reserva reserva){
        reservas.add(reserva);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
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
                "cliente=" + cliente +"\n" +
                ", reservas=" + reservas + "\n" +
                ", total=" + total +
                '}';
    }
}
