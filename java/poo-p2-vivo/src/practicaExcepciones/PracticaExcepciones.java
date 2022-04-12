package practicaExcepciones;

public class PracticaExcepciones {
    private static int a = 0;
    private static int b = 300;

    public static void main(String[] args) {
        try {
            System.out.println("Cociente de b/a = " + (b/a));
        } catch (ArithmeticException e) {
//            System.out.println("Se ha producido un error");
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
