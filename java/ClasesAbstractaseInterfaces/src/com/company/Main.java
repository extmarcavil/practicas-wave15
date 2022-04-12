package com.company;

import ejercicio2.Curriculum;
import ejercicio2.Informe;
import ejercicio2.LibroPDF;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Curriculum c = new Curriculum();
        System.out.println("Imprimir curriculum");
        c.imprimir();

        LibroPDF l = new LibroPDF();
        System.out.println("Imprimir libro");
        l.imprimir();

        Informe i = new Informe();
        System.out.println("Imprimir informe");
        i.imprimir();
    }
}
