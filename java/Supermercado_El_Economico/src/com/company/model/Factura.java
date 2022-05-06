package com.company.model;

import java.util.List;

public class Factura {

    /**
     * Atributos
     */
    private Cliente cliente;
    private List<Item> listaDeItems;
    private double totalDeLaCompra;

    /**
     * Constructor
     */
    public Factura(Cliente cliente, List<Item> listaDeItems) {
        this.cliente = cliente;
        this.listaDeItems = listaDeItems;
        this.totalDeLaCompra = 0;
    }

    /**
     * Metodos
     */
    public double calcularTotalDelaCompra() {
        totalDeLaCompra = listaDeItems.stream().mapToDouble(item -> item.getCostoUnitario() * item.getCantidadComprada()).sum();
        return totalDeLaCompra;
    }

    @Override
    public String toString() {
        return "{" +
                "cliente=" + cliente +
                ", listaDeItems=" + listaDeItems +
                ", totalDeLaCompra=" + totalDeLaCompra +
                '}';
    }

    /**
     * Getter & Setter
     */
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaDeItems() {
        return listaDeItems;
    }

    public void setListaDeItems(List<Item> listaDeItems) {
        this.listaDeItems = listaDeItems;
    }

    public double getTotalDeLaCompra() {
        return totalDeLaCompra;
    }

    public void setTotalDeLaCompra(double totalDeLaCompra) {
        this.totalDeLaCompra = totalDeLaCompra;
    }
}
