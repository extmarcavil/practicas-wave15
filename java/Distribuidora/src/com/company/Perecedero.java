package com.company;

public class Perecedero extends Producto{
    int diasPorCaducar;

    @Override
    public void calcular(int cantidadProductos) {
        switch (cantidadProductos){
            case 1:
                super.precio = precio * 1/4;
            break;
            case 2:
                super.precio = precio * 1/3;
            break;
            case 3:
                super.precio = precio * 1/2;
            break;
            default:
                super.precio = precio;

        }
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(){}
}
