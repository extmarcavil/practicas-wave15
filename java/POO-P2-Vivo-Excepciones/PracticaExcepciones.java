public class PracticaExcepciones {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try {
            double division = b/a;
        } catch (ArithmeticException exception){
            System.out.println("Se ha producido un error.");
        } finally{
            System.out.println("Programa 1 finalizado.");
        }

        try{
            double division = b/a;
        } catch (ArithmeticException exception){
            throw new IllegalArgumentException("No se puede dividir por cero.");
        } finally{
            System.out.println("Programa 2 finalizado.");
        }
    }
}
