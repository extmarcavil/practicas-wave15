public class PracticaExcepciones {
    static int a = 0;
    static int b = 300;

    public static void calcular() {
        try {
           try {
               double resultado = b / a;
           }
           catch(ArithmeticException e) {
               throw new IllegalArgumentException();
           }
        }
        catch(IllegalArgumentException e) {
            System.out.println("No se puede dividir por cero");
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }
}