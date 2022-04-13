package modelos;

import modelos.Producto;

public class Comida extends Producto {
    private String tipoComida;

    public Comida(String nombre, double costo, String tipoComida) {
        super(nombre, costo);
        this.tipoComida = tipoComida;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }
}
