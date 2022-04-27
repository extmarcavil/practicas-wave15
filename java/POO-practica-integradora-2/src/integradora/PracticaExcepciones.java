package integradora;

public class PracticaExcepciones {

    public static void main(String[] args) {

//        try{
//            int a = 0;
//            int b = 300;
//
//            int c = b / a;
//        }catch(Exception ex){
//            System.out.println("Se ha producido un error");
//        }finally {
//            System.out.println("Programa finalizado");
//        }

        try{
            int a = 0;
            int b = 300;

            int c = b / a;
        }catch(IllegalArgumentException ex){ // El programa falla, la excepción correcta es ArithmeticException
            System.out.println("No se puede dividir por cero");
        }finally {
            System.out.println("Programa finalizado");
        }
    }

}
