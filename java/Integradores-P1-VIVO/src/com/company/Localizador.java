package com.company;

import com.company.paqueteTuristico.PaqueteTuristico;

import java.util.List;
import java.util.Objects;

public class Localizador {

    /**
     * Atributos
     */
    private List<PaqueteTuristico> reservas;
    private Cliente cliente;
    private Double total;

    /**
     * Constructor
     */
    public Localizador(List<PaqueteTuristico> reservas, Cliente cliente) {
        this.reservas = reservas;
        this.cliente = cliente;
    }


    /**
     * Methods
     */
    public double calcularTotalDeReservas() {
        double totalReservas = reservas.stream().mapToDouble(reserva -> reserva.calcularPrecioDeReserva()).sum();
        System.out.println("El total de las reservas sin descuentos es: $" + totalReservas + "\n");
        return total = totalReservas;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "reservas=" + reservas + "\n" +
                ", cliente=" + cliente + "\n" +
                ", total=" + total +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localizador that = (Localizador) o;
        return Objects.equals(cliente, that.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente);
    }

    /**
     * Getter & Setter
     */
    public List<PaqueteTuristico> getReservas() {
        return reservas;
    }

    public void setReservas(List<PaqueteTuristico> reservas) {
        this.reservas = reservas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
