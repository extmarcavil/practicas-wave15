package ejercicioIntegradorSupermercado.model;

import java.util.ArrayList;

public class Factura {
    private Long id;
    private Cliente cliente;
    private ArrayList<Producto> productos;
    private double total;

    public Factura(Long id, Cliente cliente, ArrayList<Producto> productos) {
        this.id = id;
        this.cliente = cliente;
        this.productos = productos;
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
                "id=" + id +
                ", cliente=" + cliente +
                ", productos=" + productos +
                ", total=" + total +
                '}';
    }

    public void calcularTotal(){
        for (Producto producto : this.productos) {
            total += producto.getCostoUnitario() * producto.getCantComprada();
        }
    }
}
