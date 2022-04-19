package model;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Localizador {
    private static Integer contador=0;

    private Integer idLocalizador;
    private Cliente cliente;
    private List<Reserva> reservas;

    private Double total;

    List<Descuento> descuentos;

    private static Integer getId(){
        return ++contador;
    }

    public Localizador( Cliente cliente, List<Reserva> reservas) {
        this.idLocalizador = getId();
        this.cliente = cliente;
        this.reservas = reservas;
    }

    public Integer getIdLocalizador() {
        return idLocalizador;
    }

    public void setIdLocalizador(Integer idLocalizador) {
        this.idLocalizador = idLocalizador;
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Descuento> getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(List<Descuento> descuentos) {
        this.descuentos = descuentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localizador that = (Localizador) o;
        return Objects.equals(idLocalizador, that.idLocalizador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLocalizador);
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "idLocalizador=" + idLocalizador +
                ", cliente=" + cliente +
                ", reservas=" + reservas +
                ", total="+ total+
                ", descuentos="+ descuentos+
                "}\n";
    }

}
