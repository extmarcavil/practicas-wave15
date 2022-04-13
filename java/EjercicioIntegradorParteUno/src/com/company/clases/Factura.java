package com.company.clases;

import java.util.List;

public class Factura {
    private String codigo;
    private Cliente cliente;
    private List<Producto> listaProductos;
    private  double total;

    public Factura() {
    }

    public Factura(String codigo, Cliente cliente, List<Producto> listaProductos, double total) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.listaProductos = listaProductos;
        this.total = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
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
                "codigo=" + codigo +
                ", cliente=" + cliente +
                ", listaProductos=" + listaProductos +
                ", total=" + total +
                '}';
    }
}
