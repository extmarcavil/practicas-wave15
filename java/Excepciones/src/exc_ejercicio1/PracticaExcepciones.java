package exc_ejercicio1;

public class PracticaExcepciones {

    private int a = 0;
    private int b = 300;

    public void cociente() {
        try {
            int c = b/a;
        } catch (ArithmeticException e) {
            System.err.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    public void cociente2() {
        try {
            if (a == 0)
                throw new IllegalArgumentException("No se puede dividir por cero");
            int c = b/a;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
