public class PracticaExcepciones {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;
        try{
            double resultado = b/a;
        }catch(ArithmeticException e){
            throw new IllegalArgumentException("No se pouede dividir por cero.");
        }
        finally {
            System.out.println("Programa finalizado.");
        }

    }
}
