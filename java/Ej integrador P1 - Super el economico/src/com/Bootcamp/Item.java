package com.Bootcamp;

public class Item {
    private int codigo, costo, cantidad;
    private String nombre;

    public Item(int codigo, int costo, int cantidad, String nombre) {
        this.codigo = codigo;
        this.costo = costo;
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", costo=" + costo +
                ", cantidad=" + cantidad +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
