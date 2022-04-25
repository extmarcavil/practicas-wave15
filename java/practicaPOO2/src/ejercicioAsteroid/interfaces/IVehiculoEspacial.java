package ejercicioAsteroid.interfaces;

import java.awt.*;

public interface IVehiculoEspacial {

    double calcularDistancia(Point asteroide);

    void identificarse();

    void sumarPuntos();

    int obtenerPuntaje();
}
