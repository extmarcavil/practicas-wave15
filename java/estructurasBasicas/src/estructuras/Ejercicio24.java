package estructuras;

import java.util.Scanner;

/* Realizá un programa que permita al usuario ingresar dos números enteros num1 y num2,
donde el primero siempre deberá ser menor o igual al segundo. La computadora debe
mostrar la secuencia de números existentes entre ambos:
a. Incluyéndolos;  10-11-12-13-14-15
b. Excluyéndolos.  11-12-13-14
c. Invirtiéndolos: 14-13-12-11
*/

public class Ejercicio24 {

    public static void main(String[] args) {
        final Scanner teclado = new Scanner(System.in);
        int num1, num2;
        System.out.println("Ingrese el primer valor: ");
        num1 = Integer.parseInt(teclado.nextLine());
        System.out.println("Ingrese el segundo valor: ");
        num2 = Integer.parseInt(teclado.nextLine());
        // num1 <=num2 ó num2>=num1
        while (num2 < num1) {
            System.out.println("ERROR: el " + num2 + " es menor que " + num1);
            System.out.println("Ingrese el segundo valor: ");
            num2 = Integer.parseInt(teclado.nextLine());
        }
        System.out.println("Incluyéndolos");

        for(int i=num1;i<=num2; i++) { // i = i + 1
            System.out.println(i);
        }

        System.out.println("Excluyéndolos");

        for(int i=num1+1; i<num2; i++) {
            System.out.println(i);
        }
        System.out.println("Invirtiéndolos");

        for(int i=num2-1; i>num1 ; i--) {
            System.out.println(i);
        }

        teclado.close();

    }
}
