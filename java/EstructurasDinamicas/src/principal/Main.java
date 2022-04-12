package principal;
import java.util.*;

public class Main {

    public static void main(String[] args) {

    /*
     * Realizá un programa que permita ingresar dos números enteros que representen el ancho y
    el alto de una matriz de cruces. El programa debe dibujar dicha matriz.
        xxx
        xxx
        xxx
     * */

            final Scanner teclado = new Scanner(System.in);
            int ancho, alto;
            System.out.println("Ingrese el ancho de la matriz: "); //columna
            ancho = Integer.parseInt(teclado.nextLine());
            System.out.println("Ingrese el alto de la matriz: "); //fila
            alto = Integer.parseInt(teclado.nextLine());


            for (int fila=1; fila<=alto; fila++) {
                for (int columna = 1; columna<=ancho; columna++) {
                    System.out.print("X");
                }
                System.out.println();

            }



        }

}
