package model;

import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Item> items;
    private Double precioTotal;

    public Factura(Cliente cliente, List<Item> items, Double precioTotal) {
        this.cliente = cliente;
        this.items = items;
        this.precioTotal = precioTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", items=" + items +
                ", precioTotal=" + precioTotal +
                '}';
    }
}
