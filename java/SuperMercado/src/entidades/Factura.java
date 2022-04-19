package entidades;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private double totalPrice;
    private List<Item> items;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<Item> getItems() {
        return items;
    }
}
