package com.company.santiagopinzondev;

import java.util.Arrays;

public class TemperaturasGlobales {
    public static void main(String[] args) {
        String ciudades[] = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "São Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"

        };

        int matriz[][] = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        int maxNumber = 0;
        int minNumber = 0;
        String ciudadMax = "";
        String ciudadMin= "";

        for (int f=0; f< matriz.length; f++){
            for (int c=0; c< matriz[f].length; c++){
                if (matriz[f][c] > maxNumber) {
                    maxNumber = matriz[f][c];
                    ciudadMax = ciudades[f];
                }
                if (matriz[f][c] < minNumber) {
                    minNumber = matriz[f][c];
                    ciudadMin = ciudades[f];
                }
            }
        }

        System.out.println("La ciudad con max temperatura fue " + ciudadMax + " con temperatura " + maxNumber);
        System.out.println("y la ciudad con menor temp " + ciudadMin + " con " + minNumber);

        System.out.println(Arrays.toString(ciudades));
    }
}

