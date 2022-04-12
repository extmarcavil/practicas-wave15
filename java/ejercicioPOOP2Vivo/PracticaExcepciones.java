package ejercicioPOOP2Vivo;

public class PracticaExcepciones {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try{
            int resultado = b/a;

        }catch (Exception e){
            //Ejercicio 1 parte 1
            //System.out.println("Se ha producido un error");

            //Ejercicio 1 parte 2
            throw new IllegalArgumentException ("No se puede dividir por cero");
        }finally {
            System.out.println("Programa finalizado");
        }


    }







}
