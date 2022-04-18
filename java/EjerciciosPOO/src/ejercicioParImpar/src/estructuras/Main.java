package estructuras;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int a;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Ingrese el numero que quiere saber si es par o impar: ");
            a = sc.nextInt();
            sc.close();

            if (a % 2 == 0) {
                System.out.println(a + " es par");
            } else {
                System.out.println(a + " no es par");
            }
            
        } catch (InputMismatchException e) {
            System.out.println("Ingreso un valor que no es un entero");
        }

    }
}
