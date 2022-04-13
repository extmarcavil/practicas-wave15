package com.company;

public class NoPerecedero extends Producto {
    String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public NoPerecedero(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "NoPerecedero{" +
                "tipo='" + tipo + '\'' +
                '}';
    }

    @Override
    public void calcular(int cantidadProductos) {
        super.calcular(cantidadProductos);
    }

    public NoPerecedero(){}
}
