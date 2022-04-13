package ejercicioIntegradorTurismo;

import java.util.ArrayList;

public class Localizador {

    private int id;
    private Cliente cliente;
    private double total;
    private ArrayList<Reserva> reservas;

    @Override
    public String toString() {
        return "Localizador {" +
                " ID = " + id +
                ", Cliente =" + cliente +
                ", Reservas =" + reservas +
                '}';
    }

    public Localizador(int id, Cliente cliente, ArrayList<Reserva> reservas) {
        this.id = id;
        this.cliente = cliente;
        this.reservas = reservas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }



}
