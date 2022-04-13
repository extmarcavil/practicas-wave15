package Clases;

import java.util.ArrayList;

public class Factura {
    private int id_factura;
    private Cliente cliente;
    private ArrayList<Item> listado;
    private double costo_total;

    public Factura(int id_factura, Cliente cliente, ArrayList<Item> listado, double costo_total) {
        this.id_factura = id_factura;
        this.cliente = cliente;
        this.listado = listado;
        this.costo_total = costo_total;
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
}
