package POO.P2.Ejercicio1;

public class PracticaExcepciones {

    private static int a = 0;
    private static int b = 300;

    /*
    // Parte 1
    public static void main(String[] args) {
        try {
            int division = b / a;
        } catch (ArithmeticException error) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
    */

    // Parte 2
    public static void main(String[] args) {
        try {
            if (a == 0)
                throw new IllegalArgumentException("No se puede dividir por cero");

            int division = a / b;

        } catch (IllegalArgumentException error) {
            System.out.println(error);
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
