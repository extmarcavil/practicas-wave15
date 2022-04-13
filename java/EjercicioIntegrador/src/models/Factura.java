package models;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Long id;
    private Cliente cliente;
    private List<Item> items;

    public Factura() {
        this.items = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", items=" + items +
                ", total=" + this.precioTotal() +
                '}';
    }

    public Integer precioTotal() {
        return this.items
                .stream()
                .map(Item::getPrecioUnitario)
                .reduce(0, Integer::sum);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }
}
