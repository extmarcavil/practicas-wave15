package com.company;

import java.util.Scanner;

public class Practica1 {

    public static void main(String[] args) {

        int numero;

        System.out.println("Ingrese un numero");
        Scanner input = new Scanner(System.in);

        numero = input.nextInt();

        if (numero % 2 == 0) {
            System.out.println("Es Par");
        } else {
            System.out.println("Es impar");
        }

        input.close();

    }
}
