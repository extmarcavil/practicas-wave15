package Clases;

import java.util.ArrayList;

public class Factura {

    ArrayList<Item> items;
    Cliente cliente;
    Double total;


    public Factura(ArrayList<Item> items, Cliente cliente, Double total) {
        this.items = items;
        this.cliente = cliente;
        this.total = total;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
