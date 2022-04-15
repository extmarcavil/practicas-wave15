package IntegradoresP1.AgenciaTurismo;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private int id;
    private Cliente cliente;
    private double total;
    private List<Reserva> reservas = new ArrayList<>();

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

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void addReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Cliente: " + cliente + " | Total: " + total + "\nReservas: \n" + reservas;
    }

    public void imprimir() {
        System.out.println(this.toString());
    }

    public boolean hasReservaCompleta() {
        return this.reservas
                .stream()
                .map(Reserva::isCompleta)
                .reduce(false, (acc, b) -> acc || b);
    }
}
