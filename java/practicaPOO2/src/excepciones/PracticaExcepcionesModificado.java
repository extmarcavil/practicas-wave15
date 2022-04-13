package excepciones;

/*Modificar el programa anterior para que, al producirse el error, en vez de imprimir por consola el mensaje
“Se ha producido un error”, lo lance como una excepción de tipo IllegalArgumentException con el mensaje
“No se puede dividir por cero”*/

public class PracticaExcepcionesModificado {

    public static void main(String[] args) {
        int a = 0;
        int b = 300;
        double cociente;

        try {
            if (a != 0)
                cociente = b/a;
            else
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("No se puede dividir por cero.");
        } finally {
            System.out.println("Programa finalizado");
        }

    }
}
