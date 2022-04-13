package Integrador1;

import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Item> items;
    private Double total;


    public Factura(Cliente cliente, List<Item> items, Double total) {
        this.cliente = cliente;
        this.items = items;
        this.total = total;
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
