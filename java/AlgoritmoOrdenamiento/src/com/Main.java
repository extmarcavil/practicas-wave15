package com;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int array[] = { 1, 2, 6, 9, 3, 4, 7, 8 };

        for (int i=0; i< array.length; i++) {
            for (int j=0; j< i; j++) {

                if (array[i] < array[j]) {
                    int otro = array[i];
                    array[i] = array[j];
                    array[j] = otro;
                }
            }
        }
        System.out.println(Arrays.toString(array));

    }
}
