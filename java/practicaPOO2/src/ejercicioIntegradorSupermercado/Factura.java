package ejercicioIntegradorSupermercado;

import java.util.ArrayList;

public class Factura {
    private Cliente cliente;
    private ArrayList<Producto> productos;
    private double total;

    public Factura(Cliente cliente, ArrayList<Producto> productos) {
        this.cliente = cliente;
        this.productos = productos;
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

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", productos=" + productos +
                ", total=" + total +
                '}';
    }
}
