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
    public double calcular(int cantidadDeProductos) {
        double calculo = super.calcular(cantidadDeProductos);

        switch (diasPorCaducar) {
            case 1:
                calculo = calculo / 4;
                break;
            case 2:
                calculo = calculo / 3;
                break;
            case 3:
                calculo = calculo / 2;
                break;
            default:
        }
        return calculo;
    }
}
