package tryCatch;

public class PracticaExcepciones {

    //Crear una clase PracticaExcepciones que defina los atributos
    // a = 0 y b = 300 de tipo int. Calcular el cociente de b/a.
    // Controlar la excepción que se lanza indicando el mensaje
    // “Se ha producido un error”. Al final del programa siempre
    // deberá indicar el mensaje “Programa finalizado”

    // Modificar el programa anterior para que, al producirse el error,
    // en vez de imprimir por consola el mensaje “Se ha producido un
    // error”, lo lance como una excepción de tipo IllegalArgumentException
    // con el mensaje “No se puede dividir por cero”

    private int a;
    private int b;

    public PracticaExcepciones() {
        this.a = 0;
        this.b = 300;
    }

    public int calcular(){
        int resultado = 0;
        try {
            resultado = b/a;
        }catch (ArithmeticException arithmeticException){
            //System.out.println("Se ha producido un error");
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally {
            System.out.println("Programa Finalizado");
        }
        return resultado;
    }
}
