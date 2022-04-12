package herenciaYpolimorfismo;

public class PracticaExcepciones {
    public void ExceptionPractice() {
        int a = 0;
        int b = 300;

        try {
            int num = b / a;
        } catch (IllegalArgumentException e) {
            System.out.println("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
