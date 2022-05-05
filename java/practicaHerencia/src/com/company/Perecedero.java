package com.company;

public class Perecedero extends Producto {
    int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return super.toString() + ", quedandole " +  + diasPorCaducar + " dias por caducar";
    }

    @Override
    public double calcular(int cantProductos) {
        double precioBase = super.calcular(cantProductos);

        switch (diasPorCaducar) {
            case 1: return precioBase / 4;
            case 2: return precioBase / 3;
            case 3: return precioBase / 2;
            default: return precioBase;
        }
    }
}
