package com.company.santiagopinzondev;

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
    public double calcular(int cantidadProductos) {
        double precioFinal = super.calcular(cantidadProductos);

        if (diasPorCaducar == 1) {
            precioFinal /= 4;
        } else if (diasPorCaducar == 2) {
            precioFinal /= 3;
        } else if (diasPorCaducar == 3) {
            precioFinal /= 2;
        }

        return precioFinal;
    }
}
