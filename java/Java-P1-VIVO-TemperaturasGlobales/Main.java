package com.company;

import java.lang.reflect.Array;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static String [] ciudades = new String[10];
    private static Integer [][] temperaturas = new Integer[10][2];
    private static Integer minimo = 0;
    private static Integer maximo = 0;

    public static void main(String[] args) {
        cargoCiudades();
        cargoTemperaturas();
        buscoTemperaturaMinMax();
    }

    private static void cargoCiudades(){
        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asunción";
        ciudades[5] = "São Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";
    }

    private static void cargoTemperaturas(){
        //Londres
        temperaturas[0][0] = -2;
        temperaturas[0][1] = 33;

        //Madrid
        temperaturas[1][0] = -3;
        temperaturas[1][1] = 32;

        //Nueva York
        temperaturas[2][0] = -8;
        temperaturas[2][1] = 27;

        //Buenos Aires
        temperaturas[3][0] = -2;
        temperaturas[3][1] = 33;

        //Asuncion
        temperaturas[4][0] = 6;
        temperaturas[4][1] = 42;

        //São Paulo
        temperaturas[5][0] = 5;
        temperaturas[5][1] = 43;

        //Lima
        temperaturas[6][0] = 0;
        temperaturas[6][1] = 39;

        //Santiago de Chile
        temperaturas[7][0] = -7;
        temperaturas[7][1] = 26;

        //Lisboa
        temperaturas[8][0] = -1;
        temperaturas[8][1] = 31;

        //Tokio
        temperaturas[9][0] = -10;
        temperaturas[9][1] = 35;
    }

    private static void buscoTemperaturaMinMax(){
        minimo = 0;
        maximo = 0;
        String ciudadMinimo = "";
        String ciudadMaximo = "";
        for(int i = 0; i < ciudades.length;i++){
            if (temperaturas[i][0] < minimo){
                minimo = temperaturas[i][0];
                ciudadMinimo = ciudades[i];
            }

            if (temperaturas[i][1] > maximo){
                maximo = temperaturas[i][1];
                ciudadMaximo = ciudades[i];
            }
        }

        System.out.println("La ciudad con la temperatura minima es: " + ciudadMinimo + " con una temperatura minima de: " + minimo);
        System.out.println("La ciudad con la temperatura maxima es: " + ciudadMaximo + " con una temperatura maxima de: " + maximo);
    }
}
