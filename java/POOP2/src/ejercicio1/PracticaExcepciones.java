package ejercicio1;

public class PracticaExcepciones {
    private static int a=0;
    private static int b=300;

    public static double calcularCociente(){
        double result=0;
        try {
            result = b/a;
        }catch (ArithmeticException e){
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }
        return result;
    }

    public static double calcularCociente2(){
        double result=0;
        try {
            result = b/a;
        }catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
        return result;
    }

    public static void main(String[] args) {
        //calcularCociente();
        calcularCociente2();
    }

}
