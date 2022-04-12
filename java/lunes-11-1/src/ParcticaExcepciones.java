public class ParcticaExcepciones {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try {
            System.out.println(b / a);
        } catch (ArithmeticException e){
            System.out.println("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado.");
        }

    }
}
