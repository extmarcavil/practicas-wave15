package com.company.ejercicio2.nave;

import java.util.List;

public class FlotaDeNaves implements Calculando{

    /**
     * Atributos
     */
    private List<Nave> listaDeNaves;

    /**
     * Metodos
     */
    public void agregarNave(Nave nave) {
        listaDeNaves.add(nave);
    }

    public double calcularDistancia(int coordenadas[][]) {

        double distanciaPromedio = 0;

        for (Nave nave : listaDeNaves) {

            for (int i = 0; i < coordenadas.length; i++) {
                distanciaPromedio += Math.sqrt(Math.pow((nave.getCoordenadaX1() - coordenadas[i][0]), 2) + Math.pow((nave.getCoordenadaY1() - coordenadas[i][1]), 2));
            }
                distanciaPromedio = distanciaPromedio/ listaDeNaves.size();
        }
        return distanciaPromedio;
    }

}
