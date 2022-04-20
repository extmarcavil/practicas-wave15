package model;

import java.awt.*;

public class NaveEspacial extends VehiculoEspacial {
    private String nombre;
    private Point ubicacion;
    private double puntuacionInicial;

    public NaveEspacial(String nombre, int x, int y) {
        this.nombre = nombre;
        this.ubicacion = new Point(x,y);
        this.puntuacionInicial = 0;
    }

    public double calcularDistancia(Point meteorito) {
        return ubicacion.distance(meteorito);
    }

    @Override
    public String imprimirNave() {
        return "\t" + nombre + " en posicion\n";
    }

    @Override
    public void definirComoGanador() {
        this.puntuacionInicial += 1;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

