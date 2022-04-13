package Ejercicio1;

public class PracticaExcepciones {
    public static void main(String[] args) {

        int a = 0;
        int b = 300;

        try {
            double resultado = b / a;
        }
        catch (Exception ex){
            throw new IllegalArgumentException("No se puede dividir por 0");
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }


}
