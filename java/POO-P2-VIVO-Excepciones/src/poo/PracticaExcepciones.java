package poo;

public class PracticaExcepciones {
    static int a = 0, b = 300;
    public static void main(String[] args) {
        // 1
        //try {
        //    System.out.println(b/a);
        //}
        //catch (ArithmeticException e) {
        //    System.out.println("Se ha producido un error");
        //}
        //finally {
        //    System.out.println("Programa finalizado");
        //}

        //2
        try {
            System.out.println(b/a);
        }
        catch (Exception e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }
}
