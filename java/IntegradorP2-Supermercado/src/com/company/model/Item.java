package com.company.model;

public class Item {
    private Long codigo;
    private String nombre;
    private int cant;
    private double costoUnitario;

    public Item() {
    }

    public Item(Long codigo, String nombre, int cant, double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cant = cant;
        this.costoUnitario = costoUnitario;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", cant=" + cant +
                ", costoUnitario=" + costoUnitario +
                '}';
    }
}
