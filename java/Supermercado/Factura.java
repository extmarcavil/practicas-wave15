package Supermercado;

import java.util.ArrayList;

public class Factura {
    private Long codigoF;
    private double totalCompra;
    private Cliente cliente;
    private ArrayList<Item> items;

    public Factura() {
    }

    public Factura(Long codigoF, double totalCompra, Cliente cliente, ArrayList<Item> items) {
        this.codigoF = codigoF;
        this.totalCompra = totalCompra;
        this.cliente = cliente;
        this.items = items;
    }

    public Long getCodigoF() {
        return codigoF;
    }

    public void setCodigoF(Long codigoF) {
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

    @Override
    public String toString() {
        return "Factura{" +
                "codigoF=" + codigoF +
                ", totalCompra=" + totalCompra +"\n"+
                ", cliente=" + cliente +"\n"+
                ", items=" + items +"\n"+
                '}';
    }
}
