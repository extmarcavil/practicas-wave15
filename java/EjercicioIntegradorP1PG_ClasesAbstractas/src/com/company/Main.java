package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        final Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese un valor del tipo Integer");
        Integer valor = teclado.nextInt();
        System.out.println("Serie");
        PrototipoHijoUno s1 = new PrototipoHijoUno(valor);
        System.out.println(s1.valorSiguiente());
        System.out.println(s1.valorSiguiente());
        System.out.println(s1.valorSiguiente());
        System.out.println(s1.valorSiguiente());

        System.out.println("Valor inicial: " + valor);
        System.out.println("Iniciar serie nuevamente");
        System.out.println(valor);
        s1.iniciarSerie(valor);
        System.out.println(s1.valorSiguiente());
        System.out.println(s1.valorSiguiente());
        System.out.println(s1.valorSiguiente());
        System.out.println(s1.valorSiguiente());

        System.out.println("Reinicio de serie al primer valor ingresado");
        s1.reiniciarSerie();
        System.out.println("Primer valor de la serie: " + s1.valorSiguiente());

        System.out.println("Ingrese un valor del tipo Double:");
        Double valor2 = teclado.nextDouble();
        System.out.println("Serie:");
        PrototipoHijoDos s2 = new PrototipoHijoDos(valor2);
        System.out.println(s2.valorSiguiente());
        System.out.println(s2.valorSiguiente());
        System.out.println(s2.valorSiguiente());
        System.out.println(s2.valorSiguiente());

        System.out.println("Valor inicial: " + valor2);
        System.out.println("Iniciar serie nuevamente:");
        System.out.println(valor2);
        s2.iniciarSerie(valor2);
        System.out.println(s2.valorSiguiente());
        System.out.println(s2.valorSiguiente());
        System.out.println(s2.valorSiguiente());
        System.out.println(s2.valorSiguiente());

        System.out.println("Reinicio de serie al primer valor ingresado");
        s2.reiniciarSerie();
        System.out.println("Primer valor de la serie: " + s2.valorSiguiente());

    }
}
