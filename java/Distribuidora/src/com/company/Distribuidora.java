package com.company;

import java.util.ArrayList;

public class Distribuidora {
    ArrayList <Producto> producto = new ArrayList<>();

    public Distribuidora(ArrayList<Producto> producto) {
        this.producto = producto;
    }

    public ArrayList<Producto> getProducto() {
        return producto;
    }

    public void setProducto(ArrayList<Producto> producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Distribuidora{" +
                "producto=" + producto +
                '}';
    }

    public Distribuidora(){}
}
