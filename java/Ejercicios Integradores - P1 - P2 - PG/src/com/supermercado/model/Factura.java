package com.supermercado.model;

import java.util.List;

public class Factura {
    private String id;
    private Cliente cliente;
    private List<Producto> productos;
    private double total;

    public Factura() {
    }

    public Factura(String id, Cliente cliente, List<Producto> productos, double total) {
        this.cliente = cliente;
        this.productos = productos;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", productos=" + productos +
                ", total=" + total +
                '}';
    }
}
