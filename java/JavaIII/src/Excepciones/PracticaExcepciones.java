package Excepciones;

public class PracticaExcepciones {

    private static int a = 0;
    private static int b = 300;

    public static int calcularCociente(){
        return b/a;
    }

    public static void main(String[] args) {
        try{
            int c = calcularCociente();
        } catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir entre cero");
        } catch (IllegalArgumentException f){
            System.out.println("Entró a la segunda parte");
        } finally {
            System.out.println("El programa ha finalizado");
        }
    }
}
