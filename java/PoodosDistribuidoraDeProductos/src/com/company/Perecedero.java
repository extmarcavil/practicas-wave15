package com.company;

public class Perecedero extends Producto {

    private int diasPorCaducar;


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
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calucular(int cantidadDeProductos){
        double precioTotal = 0;

        if (diasPorCaducar == 1) {
            precioTotal = ((cantidadDeProductos * this.getPrecio())/4);
        } else
            if (diasPorCaducar == 2) {
                precioTotal = ((cantidadDeProductos * this.getPrecio())/3);
            } else
            if (diasPorCaducar == 3) {
                precioTotal = ((cantidadDeProductos * this.getPrecio())/2);
            }

        return precioTotal;
    }
}
