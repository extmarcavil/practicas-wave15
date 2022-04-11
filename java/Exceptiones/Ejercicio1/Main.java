package ejercicio1;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        PracticaExcepciones excepcion = new PracticaExcepciones();
        try {
            double rta = excepcion.dividir();
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
            throw new IllegalAccessException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa Finalizado");
        }
    }
}
