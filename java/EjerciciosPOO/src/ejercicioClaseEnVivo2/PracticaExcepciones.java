package ejercicioClaseEnVivo2;

public class PracticaExcepciones {
    int a = 0;
    int b = 300;

    public void calcularCociente() {
        try {
            int result = b / a;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
