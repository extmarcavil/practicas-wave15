package EjercicioPractico2POO;

public class PracticaExcepciones {
    public static void main(String[] args) {
        int a= 0;
        int b =300;
        try {
           int c = b/a;
        }catch (ArithmeticException exception){
            System.out.println("se ha producido un error: " + exception.getMessage());
            throw new IllegalArgumentException("No se puede divivir por 0");
        }finally {
            System.out.println("programa finalizado");
        }
    }
}
