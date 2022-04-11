package com.company;

public class PracticaExcepciones {

    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try {
            double division = b/a;
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa Finalizado");
        }

        try {
            double division = b/a;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa Finalizado");
        }
    }
}
