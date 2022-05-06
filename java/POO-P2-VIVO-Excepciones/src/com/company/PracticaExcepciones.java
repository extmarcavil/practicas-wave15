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

            if (a == 0) {
                throw new IllegalArgumentException("No es posible dividir por 0");
            }
            retorno = b / a;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Programa finalizado");
        }
        return retorno;
    }
}
