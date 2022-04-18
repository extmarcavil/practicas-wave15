package ar.com.alehenestroza;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double precioTotal;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        items = new ArrayList<Item>();
        precioTotal = 0;
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

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public void addItem(Item item) {
        this.items.add(item);
        precioTotal += item.getPrecioUnitario() * item.getCantidadComprada();
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
