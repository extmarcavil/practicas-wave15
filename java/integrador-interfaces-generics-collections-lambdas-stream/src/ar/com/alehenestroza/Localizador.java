package ar.com.alehenestroza;

import java.util.ArrayList;

public class Localizador {
    private Cliente cliente;
    private ArrayList<Producto> productos;
    private double total;

    public Localizador(Cliente cliente, ArrayList<Producto> productos, double total) {
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

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
