package Excepciones;

public class Main {
    public static void main(String[] args) {
         int a = 0;
         int b = 300;
         double cociente = 0;
         try {
             cociente = b/a;
         } catch (ArithmeticException e) {
//             System.out.println("Se ha producido un error");
             throw new IllegalArgumentException("No se puede dividir por cero");
         }
    }
}
