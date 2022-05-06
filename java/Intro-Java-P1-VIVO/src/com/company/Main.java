package com.company;

import org.w3c.dom.ls.LSOutput;

public class Main {

    public static void main(String[] args) {
        // write your code here

        /**
         * Resolucion
         */
        String ciudades[] = new String[10];

        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asunsion";
        ciudades[5] = "Sao Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        int temperaturas[][] = new int[10][2];

        /**
         * Columna 1 Temperaturas minimas
         */
        temperaturas[0][0] = -2;
        temperaturas[1][0] = -3;
        temperaturas[2][0] = -8;
        temperaturas[3][0] = 4;
        temperaturas[4][0] = 6;
        temperaturas[5][0] = 5;
        temperaturas[6][0] = 0;
        temperaturas[7][0] = -7;
        temperaturas[8][0] = -1;
        temperaturas[9][0] = -10;

        /**
         * Temperaturas maximas
         */
        temperaturas[0][1] = 33;
        temperaturas[1][1] = 32;
        temperaturas[2][1] = 27;
        temperaturas[3][1] = 37;
        temperaturas[4][1] = 42;
        temperaturas[5][1] = 43;
        temperaturas[9][1] = 39;
        temperaturas[6][1] = 26;
        temperaturas[7][1] = 31;
        temperaturas[8][1] = 35;


        /**
         * Ejecutando los metodos para conocer las noticias
         */
        tempMaxima(ciudades, temperaturas);
        tempMinima(ciudades, temperaturas);


    }


    /**
     * Methods.
     * Temperatura Maxima
     *
     * @param ciudades
     * @param temperaturaMaximas
     */
    public static void tempMaxima(String ciudades[], int temperaturaMaximas[][]) {

        String city = "";
        int tempMax = 0;

        for (int i = 0; i < ciudades.length; i++) {
            if (ciudades[i] != null) {
                while (temperaturaMaximas[i][1] > tempMax) {
                    city = ciudades[i];
                    tempMax = temperaturaMaximas[i][1];
                }
            }
        }
        System.out.println("La temperatura maxima fue en la ciudad de " + city + " con una temperatura de " + tempMax + "ªC.");
    }

    /**
     * Temperatura Minima
     */
    public static void tempMinima(String ciudades[], int temperaturasMinimas[][]) {

        String city = "";
        int tempMax = 0;

        for (int i = 0; i < ciudades.length; i++) {
            if (ciudades[i] != null) {
                while (temperaturasMinimas[i][0] < tempMax) {
                    city = ciudades[i];
                    tempMax = temperaturasMinimas[i][0];
                }
            }
        }
        System.out.println("La temperatura minima fue en la ciudad de " + city + " con una temperatura de " + tempMax + "ªC.");
    }


}
