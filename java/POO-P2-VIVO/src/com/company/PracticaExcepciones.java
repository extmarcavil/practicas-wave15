package com.company;

import java.net.StandardSocketOptions;

public class PracticaExcepciones {

    private int a =0;
    private int b = 300;
    private int division;

    public void calcularCociente(){
        try {
            division = b / a;
        }catch(ArithmeticException e){
            //e.printStackTrace();
            throw new IllegalArgumentException("No se puede dividir por 0");
        }finally {
            System.out.print("Division = " + division);
            System.out.print(" - Programa Finalizado");
        }


    }
}
