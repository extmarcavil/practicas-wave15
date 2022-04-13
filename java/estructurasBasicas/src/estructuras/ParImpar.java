package estructuras;

import java.util.Scanner;

public class ParImpar {
    public static void main(String[] args) {
        int numero;

        // Pedir ingreso de los números

        System.out.println("Ingrese un nùmero: ");
        Scanner teclado = new Scanner(System.in);
        numero = teclado.nextInt();
        // numero = Integer.parseInt(teclado.nextLine()); ---> toma lo ingresado menos el salto de linea

        if(numero % 2 == 0){
            System.out.println("El número es par");
        }
        else {
            System.out.println("El número es impar");
        }
        teclado.close();

    }
}
