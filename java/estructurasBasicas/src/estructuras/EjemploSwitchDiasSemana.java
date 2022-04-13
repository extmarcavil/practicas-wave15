package estructuras;

import java.util.Scanner;

public class EjemploSwitchDiasSemana {

    public static void main(String[] args) {
        int dia;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese un número válido para un día de la semana: ");
        dia = teclado.nextInt();
        teclado.close();
        String diaString;
        //Empezamos con el switch

        switch(dia) {
            case 1: diaString = "lunes";
                break;
            case 2: diaString = "martes";
                break;
            case 3: diaString = "miercoles";
                break;
            case 4: diaString = "jueves";
                break;
            case 5: diaString = "viernes";
                break;
            case 6: diaString = "sabado";
                break;
            case 7: diaString = "domingo";
                break;
            default: diaString = "día invalido";
                break;
        }

        System.out.println(diaString);

    }

}
