package ejercicio1;

public class PracticaExcepciones {

    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try{
            int cociente = b/a;
            System.out.println(cociente);
        }catch (ArithmeticException e){
            //System.out.println(e.getMessage());
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally {
            System.out.println("Programa finalizado");
        }
    }
}
