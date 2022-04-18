public class PracticaExcepciones {

    int a;
    int b;

    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public double calcularCociente() {
        double cociente = -1;

        try {
            cociente = b/a;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
        return cociente;
    }
}
