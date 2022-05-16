package com.company;

public class Main {

    public static void main(String[] args) {
        String [] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        Integer [][] temperaturas = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};;

        Integer max = temperaturas[0][1];
        Integer min = temperaturas[0][0];
        String maxCity = ciudades[0];
        String minCity = ciudades[0];

        for (int i = 0; i < temperaturas.length; i++){
           if (temperaturas[i][1] > max){
               max = temperaturas[i][1];
               maxCity = ciudades[i];
           }
            if (temperaturas[i][0] < min){
                min = temperaturas[i][0];
                minCity = ciudades[i];
            }
        }

        System.out.println("La menor temperatura la tuvo: " + minCity + " con un temperatura de: " + min + " grados.");
        System.out.println("La meyor temperatura la tuvo: " + maxCity + " con un temperatura de: " + max + " grados.");

    }
}
