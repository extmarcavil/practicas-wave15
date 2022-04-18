package Clases;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Factura {
    private int id_factura;
    private Cliente cliente;
    private ArrayList<Item> listado;
    private double costo_total;

    public Factura(int id_factura, Cliente cliente, ArrayList<Item> listado) {
        this.id_factura = id_factura;
        this.cliente = cliente;
        this.listado = listado;
        this.costo_total = 0;
    }

    public int getId_factura() {
        return id_factura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Item> getListado() {
        return listado;
    }

    public double getCosto_total() {
        return costo_total;
    }
    public void agregarProducto(Item producto){
        this.listado.add(producto);
        this.costo_total += producto.getCosto_unitario() * producto.getCantidad_comprada();
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id_factura=" + id_factura +
                ", cliente=" + cliente +
                ", listado=" + listado +
                ", costo_total=" + costo_total +
                '}';
    }
}
