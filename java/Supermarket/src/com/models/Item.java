package com.models;

import java.util.List;
import java.util.Scanner;

public class Item {

    private String nombre;
    private int codigo;
    private int cantidad;
    private double costo;
    private Scanner in = new Scanner(System.in);

    public Item(String nombre, int codigo, int cantidad, double costo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public Item() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Items{" +
                "nombre='" + nombre + '\'' +
                ", codigo=" + codigo +
                ", cantidad=" + cantidad +
                ", costo=" + costo +
                '}';
    }


}
