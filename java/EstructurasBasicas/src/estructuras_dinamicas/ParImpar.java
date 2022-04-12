package estructuras_dinamicas;

import java.util.Scanner;

public class ParImpar {
    public static void main(String[] args) {
        final Scanner reader = new Scanner(System.in);
        int numberA = reader.nextInt();
        if (numberA % 2 == 0)
            System.out.println("El numero: " + numberA + " es par.");
        else
            System.out.println("El numero: " + numberA + " es impar.");

        reader.close();
    }
}
