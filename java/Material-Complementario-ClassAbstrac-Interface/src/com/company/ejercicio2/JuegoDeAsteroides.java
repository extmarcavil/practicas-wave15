package com.company.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class JuegoDeAsteroides {

    /**
     * Atributos
     */
    private List<Participante> listaParticipantes;
    private int coordenadas[][];


    public JuegoDeAsteroides(int coordenadas[][]) {
        this.listaParticipantes = new ArrayList<>();
        this.coordenadas = coordenadas;
    }

    public void inscribirParticipantes(Participante participante) {
        listaParticipantes.add(participante);
    }

    public void jugar() {

        double distanciaPorCoordenada = 0;
        List<Double> distancias = new ArrayList<>();

        for (Participante participante : listaParticipantes) {

            if (participante.getNaveSimple() != null) {
                distanciaPorCoordenada = participante.getNaveSimple().calcularDistancia(coordenadas);
                distancias.add(distanciaPorCoordenada);

                for (int i = 0; i < listaParticipantes.size(); i++) {

                }
            }

            if (participante.getFlotaDeNaves() != null) {
                distanciaPorCoordenada = participante.getFlotaDeNaves().calcularDistancia(coordenadas);
            }


        }
    }
}
