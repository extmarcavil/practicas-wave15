package excepciones;

public class PracticaExcepciones {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;
        double resultado = 0;
        try{
            resultado = b/a;
        }catch (ArithmeticException e){
            System.out.println("Se ha producido un error");
            e.printStackTrace(System.out);
        }finally {
            System.out.println("Programa finalizado");
        }
    }

}
