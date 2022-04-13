package supermercadoElEconomico;

import java.util.ArrayList;

public class Factura {
    private Cliente cliente;
    private ArrayList<Item> listaItems;
    private double totalCompra;

    public Factura(Cliente cliente, ArrayList<Item> listaItems) {
        this.cliente = cliente;
        this.listaItems = listaItems;
    }

    public void calcularTotal(){

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Item> getListaProductos() {
        return listaItems;
    }

    public void setListaProductos(ArrayList<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }
}
