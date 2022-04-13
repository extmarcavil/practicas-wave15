package models;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Localizador extends Entity {
    private Cliente cliente;
    private Double total;
    private List<Reserva> reservas = new ArrayList<>();

    public void imprimir() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "id=" + this.getId() +
                ", cliente=" + cliente +
                ", total=" + total +
                ", reservas=" + reservas +
                '}';
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void addReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    public boolean hasReservaCompleta() {
        return this.hasSomething(Reserva::isCompleta);
    }

    public boolean hasBoletoDeViaje() {
        return this.hasSomething(Reserva::hasBoletoDeViaje);
    }

    public boolean hasReservaDeHotel() {
        return this.hasSomething(Reserva::hasReservaDeHotel);
    }

    private boolean hasSomething(Function<Reserva, Boolean> fun) {
        return this.reservas
                .stream()
                .map(fun)
                .reduce(false, Boolean::logicalOr);
    }
}
