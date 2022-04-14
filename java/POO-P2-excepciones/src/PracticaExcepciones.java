public class PracticaExcepciones {

    public static void main(String[] args) {

        int a = 0;
        int b = 300;

        try {
            int c = b / a;
        }catch (ArithmeticException e){
            //System.out.println("Se ha producido un error");
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally {
            System.out.println("Programa finalizado");
        }
    }
}
