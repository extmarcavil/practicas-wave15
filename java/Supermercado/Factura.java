package Supermercado;

import java.util.ArrayList;

public class Factura {
    private long codigoF;
    private double totalCompra;
    private Cliente cliente;
    private ArrayList<Item> items;

    public Factura() {
    }

    public Factura(long codigoF, double totalCompra, Cliente cliente, ArrayList<Item> items) {
        this.codigoF = codigoF;
        this.totalCompra = totalCompra;
        this.cliente = cliente;
        this.items = items;
    }

    public long getCodigoF() {
        return codigoF;
    }

    public void setCodigoF(long codigoF) {
        this.codigoF = codigoF;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
