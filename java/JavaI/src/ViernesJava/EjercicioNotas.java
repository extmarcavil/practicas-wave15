package ViernesJava;

import java.util.Scanner;

public class EjercicioNotas {
    public static void main(String[] args) {
        int calificacion;
        System.out.println("Ingrese calificación:");
        Scanner entrada = new Scanner(System.in);

        calificacion = entrada.nextInt();

        if (calificacion < 5){
            System.out.println("Reprobado");
        } else {
            System.out.println("Aprobado");
        }
    }
}
