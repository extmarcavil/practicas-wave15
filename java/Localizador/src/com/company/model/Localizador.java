package com.company.model;

import java.text.DecimalFormat;

public class Localizador {

    private Paquete paquete;
    private Cliente cliente;
    private Double precioTotal;

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("####0.00");
        return "Localizador{" +
                "paquete=" + paquete +
                ", cliente=" + cliente +
                ", precioTotal=" + df.format(precioTotal) +
                '}';
    }


    public Localizador(Paquete paquete, Cliente cliente) {
        this.paquete = paquete;
        this.cliente = cliente;
    }
}
