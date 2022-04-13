package Excepciones;

public class PracticaExcepciones {

    public static void main(String[] args) {
        int divisor = 0;
        int dividendo = 300;

        dividir(dividendo, divisor);
    }

    public static void dividir(int dividendo, int divisor) {
        try {
            if(divisor == 0)
                throw new IllegalArgumentException("No se puede dividir por 0");
            else
                System.out.println(dividendo / divisor);
        }
        catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        finally {
                System.out.println("Fin del programa");
        }
    }
}

