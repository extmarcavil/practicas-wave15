package ejercicioAsteroid.clases;

import ejercicioAsteroid.interfaces.IVehiculoEspacial;

import java.awt.*;
import java.util.List;

public class Flota implements IVehiculoEspacial {

    private List<Nave> naves;
    
    public Flota(List<Nave> naves) { this.naves = naves; }

    @Override
    public double calcularDistancia(Point asteroide) {
        Double sumaDistanciasFlota =
                naves.stream()
                    .map(x -> x.calcularDistancia(asteroide))
                    .reduce(0D,Double::sum);

        return sumaDistanciasFlota/ naves.size();
    }

    @Override
    public void identificarse() {
        System.out.println("Flota de naves: ");
        for (IVehiculoEspacial naves : naves)
            naves.identificarse();
    }

    @Override
    public void sumarPuntos() {
        //EL puntaje solo debe sumarse en una nave ya que la distancia calculada es el promedio de distancias de las naves de la flota
        this.naves.stream().findFirst().get().sumarPuntos();
    }

    @Override
    public int obtenerPuntaje() {
        Integer puntajeTotal =
                naves.stream()
                        .map(x -> x.obtenerPuntaje())
                        .reduce(0,Integer::sum);
        return puntajeTotal;
    }


}
