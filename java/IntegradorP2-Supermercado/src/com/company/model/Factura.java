package com.company.model;

import java.util.List;

public class Factura {
    private Long codigoFactura;
    private Cliente client;
    private List<Item> listaItems;
    private double totalCompra;

    public Factura() {
    }

    public Factura(Long codigoFactura, Cliente client, List<Item> listaItems, double totalCompra) {
        this.codigoFactura = codigoFactura;
        this.client = client;
        this.listaItems = listaItems;
        this.totalCompra = totalCompra;
    }

    public Long getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(Long codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "codigoFactura=" + codigoFactura +
                ", client=" + client +
                ", listaItems=" + listaItems +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
