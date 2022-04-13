package estructuras;

import java.util.Scanner;

public class ParImpar {

    public static void main(String[] args){
        int numero;
        System.out.println("Ingrese un numero");
        Scanner entrada = new Scanner(System.in);
        numero = entrada.nextInt();

        if(numero%2==0){
            System.out.println("Es par");
        } else {
            System.out.println("Es impar");
        }

        entrada.close();
    }
}
