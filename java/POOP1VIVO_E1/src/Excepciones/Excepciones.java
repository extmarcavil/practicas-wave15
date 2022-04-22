package Excepciones;

public class Excepciones {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        // Punto 1
        try {
            double c = b/a;
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }


        // Punto 2
        try {
            double c = b / a;

        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }


    }

}
