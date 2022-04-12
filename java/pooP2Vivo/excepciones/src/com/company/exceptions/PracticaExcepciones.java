package com.company.exceptions;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public void calcularCociente(){
        try{
            System.out.println(b/a);
        } catch(ArithmeticException e) {
            //System.out.println("Se ha producido un error.");
            throw new IllegalArgumentException("No se puede dividir por cero.");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
