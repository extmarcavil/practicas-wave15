package model;

import java.util.List;

public class Factura {

    private String codigo;
    private Cliente cliente;
    private List<Item> listaItems;
    private double montoTotal;

    public Factura(String codigo, Cliente cliente, List<Item> listaItems, double montoTotal) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.montoTotal = montoTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "codigo='" + codigo + '\'' +
                ", cliente=" + cliente +
                ", listaItems=" + listaItems +
                ", montoTotal=" + montoTotal +
                '}';
    }
}
