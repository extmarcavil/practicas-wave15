package com.company.ejercicio2.nave;

public class Nave implements Calculando {

    /**
     * Atributos
     */
    private String nombre;
    private int coordenadaX1;
    private int coordenadaY1;


    /**
     * Metodos
     */
    public double calcularDistancia(int coordenadas[][]) {

        double distancia = 0;

        for (int i = 0; i < coordenadas.length; i++) {
            distancia = Math.sqrt(Math.pow((coordenadaX1 - coordenadas[i][0]), 2) + Math.pow((coordenadaY1 - coordenadas[i][1]), 2));
        }
        return distancia;
    }


    /**
     * Getter & Setter
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCoordenadaX1() {
        return coordenadaX1;
    }

    public void setCoordenadaX1(int coordenadaX1) {
        this.coordenadaX1 = coordenadaX1;
    }

    public int getCoordenadaY1() {
        return coordenadaY1;
    }

    public void setCoordenadaY1(int coordenadaY1) {
        this.coordenadaY1 = coordenadaY1;
    }
}
