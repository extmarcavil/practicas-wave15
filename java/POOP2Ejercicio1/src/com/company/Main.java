package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int a = 0;
        int b = 300;
        int resultado = 0;

        PracticaExcepciones p = new PracticaExcepciones(a,b);
         try {
             resultado = (b/a);
         } catch (IllegalArgumentException e) {
             //catch (Exception e) {
            // System.out.println("No se puede dividir por cero”");
            System.out.println(e.getMessage());
         } finally {
             System.out.println("Programa finalizado");
         }

    }
}
