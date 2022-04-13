package uy.com.vparula;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> productos;
    private double total;

    public Factura() {
    }

    public Factura(Cliente cliente, List<Item> productos, double total) {
        this.cliente = cliente;
        this.productos = productos;
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getProductos() {
        return productos;
    }

    public void setProductos(List<Item> productos) {
        this.productos = productos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
