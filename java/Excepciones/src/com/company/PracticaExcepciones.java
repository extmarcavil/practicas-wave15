package com.company;

public class PracticaExcepciones {

    private int a = 0;
    private int b = 300;

    public double calcular() {

        double retorno = 0;

        try {
            retorno = b / a;

        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }
        return retorno;
    }

    public double calcular2() {

        double retorno = 0;

        try {
            retorno = b/a;

        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No es posible dividir por 0");
        } finally {
            System.out.println("Programa finalizado");
        }
        return retorno;
    }
}
