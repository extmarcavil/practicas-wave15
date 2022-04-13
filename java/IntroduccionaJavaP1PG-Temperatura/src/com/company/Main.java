package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] cities = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temp = {{-2, -3, -8, 4, 6, 5, 0, -7, -1, -10}, {33, 32, 27, 37, 42, 43, 39, 26, 31, 35}};

        int index_min = 0;
        int index_max = 0;

        for (int i = 1; i < cities.length; i++) {
            if (temp[1][i] > temp[1][index_max])
                index_max = i;

            if (temp[0][i] < temp[0][index_min])
                index_min = i;
        }

        System.out.println("La menor temperatura la tuvo " + cities[index_min] + " con " + temp[0][index_min]);
        System.out.println("La mayor temperatura la tuvo " + cities[index_max] + " con " + temp[1][index_max]);
    }
}
