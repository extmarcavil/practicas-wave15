package com.company.santiagopinzondev;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            double division = PracticaExcepciones.b / PracticaExcepciones.a;
            System.out.println(division);
        } catch (Exception e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
