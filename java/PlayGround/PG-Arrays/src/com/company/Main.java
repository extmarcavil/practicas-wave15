package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] ciudades = new String[]{
                "Buenos Aires     ",
                "Londres          ",
                "Madrid           ",
                "Nueva York       ",
                "Asunción         ",
                "São Paulo        ",
                "Lima             ",
                "Santiago de Chile",
                "Lisboa           ",
                "Tokio            "
        };

        int[] temperaturasMinimasDeCiudades = new int[]{-2,-3,-8,4 ,6 ,5 ,0 ,-7,-1,-10};
        int[] temperaturasMaximasDeCiudades = new int[]{33,32,27,37,42,43,39,26,31,35 };

        int temperaturaMasFria = 99999;
        int temperaturaMasCaliente = -99999;
        int indiceCiudadMasCaliente = -1;
        int indiceCiudadMasFria = - 1;

        for(int indiceCadaCiudad = 0; indiceCadaCiudad < ciudades.length ; indiceCadaCiudad++){
            int temperaturaMasFriaTemporal = temperaturasMinimasDeCiudades[indiceCadaCiudad];
            int temperaturaMasCalienteTemporal = temperaturasMaximasDeCiudades[indiceCadaCiudad];

            if( temperaturaMasFriaTemporal < temperaturaMasFria){
                temperaturaMasFria = temperaturaMasFriaTemporal;
                indiceCiudadMasFria = indiceCadaCiudad;
            }
            if( temperaturaMasCalienteTemporal > temperaturaMasCaliente ){
                temperaturaMasCaliente = temperaturaMasCalienteTemporal;
                indiceCiudadMasCaliente = indiceCadaCiudad;
            }
        }
        if( areInvalidCityParameters(ciudades, temperaturasMinimasDeCiudades, temperaturasMaximasDeCiudades, temperaturaMasFria, temperaturaMasCaliente, indiceCiudadMasCaliente, indiceCiudadMasFria) )
            System.out.println("No puede procesarse la temperatura maxima o minima");
        else{
            System.out.println("La temperatura mas fria es : " + temperaturaMasFria + "º en la ciudad de " + ciudades[indiceCiudadMasFria]);
            System.out.println("La temperatura mas caliente es : " + temperaturaMasCaliente + "º en la ciudad de " + ciudades[indiceCiudadMasCaliente]);
        }

    }

    private static boolean areInvalidCityParameters(String[] ciudades, int[] temperaturasMinimasDeCiudades, int[] temperaturasMaximasDeCiudades, int temperaturaMasFria, int temperaturaMasCaliente, int indiceCiudadMasCaliente, int indiceCiudadMasFria) {
        return temperaturaMasFria == 99999 ||
                temperaturaMasCaliente == -99999 ||
                indiceCiudadMasCaliente == -1 ||
                indiceCiudadMasFria == -1 ||
                ciudades.length == 0 ||
                temperaturasMaximasDeCiudades.length == 0 ||
                temperaturasMinimasDeCiudades.length == 0;
    }
}
