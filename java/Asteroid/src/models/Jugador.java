package models;

import java.util.ArrayList;
import java.util.List;

public abstract class Jugador {
    private List<List<Float>> coordenadasGanadas = new ArrayList<>();
    private Integer puntuacion = 0;

    // devuelve la distancia a las coordenadas
    public abstract Float atacarCoordenadas(Float x, Float y);

    public void addPuntuacion(Integer puntuacion) {
        this.puntuacion += puntuacion;
    }

    public Integer getPuntuacion() {return this.puntuacion;}

    public void addCoordenadaGanada(List<Float> coords) {
        this.coordenadasGanadas.add(coords);
    }

    public abstract void imprimirCoordenadasGanadas();

    public List<List<Float>> getCoordenadasGanadas() {
        return coordenadasGanadas;
    }
}
