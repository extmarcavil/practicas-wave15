package ejercicioAsteroid.clases;

import ejercicioAsteroid.interfaces.IVehiculoEspacial;

import java.awt.*;

public class Nave implements IVehiculoEspacial {

    private String nombre;
    private Point ubicacion;
    private int puntuacion;

    public Nave(String nombre, int coordenadaX, int coordenadaY) {
        this.nombre = nombre;
        this.ubicacion = new Point(coordenadaX, coordenadaY);
        this.puntuacion = 0;
    }

    @Override
    public double calcularDistancia(Point asteroide) {
        return ubicacion.distance(asteroide);
    }

    @Override
    public void identificarse() {
        System.out.println("Nombre de la nave: " + this.nombre);
    }

    @Override
    public void sumarPuntos() {
        this.puntuacion+=1;
    }

    @Override
    public int obtenerPuntaje() {
        return this.puntuacion;
    }


}
