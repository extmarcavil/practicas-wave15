public class PracticaExcepciones {

    public static void main(String[] args) {

        // Ejercicio 1
        /*
        int a = 0;
        int b = 300;

        try {
            int resultado = b/a;
        }catch (ArithmeticException e){
            System.out.println("Se ha producido un error.");
        }
        finally {
            System.out.println("Programa finalizado.");
        }*/

        // Ejercicio 2
        int a = 0;
        int b = 300;

        try {

            if (a == 0){
                throw new IllegalArgumentException("No se puede dividir por cero.");
            }
            else{
                int resultado = b/a;
            }


        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        finally {
            System.out.println("Programa finalizado.");
        }



    }

}
