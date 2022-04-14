package com.company;

public class PracticaExcepciones {
    int a = 0, b = 300;
    int resultado;

    public void calcularCociente(){
        try{
            System.out.println(b/a);
        }catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally {
            System.out.println("programa finalizado");
        }
    }
}
