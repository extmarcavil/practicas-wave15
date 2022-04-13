package exception;

public class PracticaException {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try{
               int resultado = b/a;
        }
        catch(ArithmeticException exception){
             throw new IllegalArgumentException("No se puede dividir por 0");
        }
        finally {
            System.out.println("Programa finalizado");
        }



    }
}
