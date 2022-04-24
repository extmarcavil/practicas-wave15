package com.company;

public class Main {

    private static String[] cities = new String[10];
    private static int[][] temperaturas = new int[2][10];

    public static void main(String[] args) {
        cargaDatos();
        int ubicacionMasAlto = obtenerTemperaturaAlta();
        String ciudadMasAlto = cities[ubicacionMasAlto];
        System.out.println("La ciudad con temperatura mas alta es: " + ciudadMasAlto);
        System.out.println("La ciudad con temperatura mas baja es: " + cities[obtenerTemperaturaBaja()]);
    }

    public static void cargaDatos () {
        cities[0] = "Londres";
        cities[1] = "Madrid";
        cities[2] = "Nueva York";
        cities[3] = "Buenos Aires";
        cities[4] = "Asunción";
        cities[5] = "Sao Paulo";
        cities[6] = "Lima";
        cities[7] = "Santiago de Chile";
        cities[8] = "Lisboa";
        cities[9] = "Tokio";
        temperaturas[0][0] = -2;
        temperaturas[0][1] = -3;
        temperaturas[0][2] = -8;
        temperaturas[0][3] = 4;
        temperaturas[0][4] = 6;
        temperaturas[0][5] = 5;
        temperaturas[0][6] = 0;
        temperaturas[0][7] = -7;
        temperaturas[0][8] = -1;
        temperaturas[0][9] = -10;
        temperaturas[1][0] = 33;
        temperaturas[1][1] = 32;
        temperaturas[1][2] = 27;
        temperaturas[1][3] = 37;
        temperaturas[1][4] = 42;
        temperaturas[1][5] = 43;
        temperaturas[1][6] = 39;
        temperaturas[1][7] = 26;
        temperaturas[1][8] = 31;
        temperaturas[1][9] = 35;
    }

    public static int obtenerTemperaturaAlta () {
        int temperaturaAlta = temperaturas[1][0];
        int ubicacion = 0;
        for (int i = 0; i < temperaturas[1].length; i++) {
            if (temperaturas[1][i] > temperaturaAlta) {
                temperaturaAlta = temperaturas[1][i];
                ubicacion = i;
            }
        }
        return ubicacion;
    }

    public static int obtenerTemperaturaBaja () {
        int temperaturaBaja = temperaturas[0][0];
        int ubicacion = 0;
        for (int i = 0; i < temperaturas[0].length; i++) {
            if (temperaturas[0][i] < temperaturaBaja) {
                temperaturaBaja = temperaturas[0][i];
                ubicacion = i;
            }
        }
        return ubicacion;
    }
}
