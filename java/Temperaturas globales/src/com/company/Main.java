package com.company;
import java.util.LinkedList;
import java.util.List;

    public class Main {
        public static void main(String[] args) {

            String temp[] = new String[10];

            temp[0] = "Londres";
            temp[1] = "Madrir";
            temp[2] = "Nueva York";
            temp[3] = "Buenos Aires";
            temp[4] = "Asuncion";
            temp[5] = "Sao Paulo";
            temp[6] = "Lima";
            temp[7] = "Santiago de Chile";
            temp[8] = "Lisboa";
            temp[9] = "Tokio";

            int cityTemp[][] = new int[10][10];


            cityTemp[0][0] = -2;
            cityTemp[1][0] = -3;
            cityTemp[2][0] = -8;
            cityTemp[3][0] = 4;
            cityTemp[4][0] = 6;
            cityTemp[5][0] = 5;
            cityTemp[6][0] = 0;
            cityTemp[7][0] = -7;
            cityTemp[8][0] = -1;
            cityTemp[9][0] = -10;
            cityTemp[0][1] = 33;
            cityTemp[1][1] = 32;
            cityTemp[2][1] = 27;
            cityTemp[3][1] = 37;
            cityTemp[4][1] = 42;
            cityTemp[5][1] = 43;
            cityTemp[6][1] = 39;
            cityTemp[7][1] = 26;
            cityTemp[8][1] = 31;
            cityTemp[9][1] = 35;

            int minTemp = cityTemp[0][0];
            int maxTemp = cityTemp[0][1];
            String maxCity = "";
            String minCity = "";

            for (int f = 0; f < 10; f++) {

                if (cityTemp[f][0] < minTemp) {
                    minTemp = cityTemp[f][0];
                    minCity = temp[f];
                }
                if (cityTemp[f][1] > maxTemp) {
                    maxTemp = cityTemp[f][1];
                    maxCity = temp[f];
                }
            }

            System.out.println("La menor temperatura la obtuvo " + minCity + " con: " + minTemp);
            System.out.println("La mayor temperatura la obtuvo " + maxCity + " con: " + maxTemp);

        }
    }




