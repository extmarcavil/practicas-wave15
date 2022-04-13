package firstEncounter;

import java.util.Scanner;

public class ParImpar {
    public static void main(String[] args) {
        int number;
        System.out.println("Introduzca numero a evaluar");
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        scan.close();
        if(input%2==0){
            System.out.println("Es par");
        } else {
            System.out.println("Es impar");
        }
    }
}
