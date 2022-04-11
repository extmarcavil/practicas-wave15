package com.company.clases;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(int diasPorCaducar, double precio, String nombre) {
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
    public double calcular(int cantidadDeProductos) {
        double precio = getPrecio() * cantidadDeProductos;
        switch (diasPorCaducar){
            case 1:
                //reducir 4 veces el precio
                precio = precio/4;
                break;
            case 2:
                // reducir 3 veces el precio
                precio = precio/3;
                break;
            case 3:
                // reducir a la mitad el precio
                precio = precio/2;
                break;
        }

        return precio;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
