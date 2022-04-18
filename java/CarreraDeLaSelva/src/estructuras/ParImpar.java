package estructuras;

import java.util.Scanner;

public class ParImpar {
    public static void main(String[] args) {
        int numero;
        System.out.println("Ingrese un numero:");
        Scanner scanner = new Scanner(System.in);
        numero = scanner.nextInt();
        scanner.close();
        System.out.println("Numero: " + numero);
        if (numero % 2 == 0) {
            System.out.println("El numero es par.");
        } else {
            System.out.println("El numero es impar.");
        }
    }
}
