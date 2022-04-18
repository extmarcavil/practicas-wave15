package ejercicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {


    /*String [] p1, p2, p3, p4, p5, p6;
    p1 = new String[]{"1111111", "Jose", "Perez", "20", "3512343434", "3512313131", "0+"};
    p2 = new String[]{"2222222", "Ramiro", "Pedroza", "15", "3512343434", "3512313131", "0+"};
    p3 = new String[]{"3333333", "Fabiana", "Rama", "40", "3512343434", "3512313131", "0+"};
    p4 = new String[]{"4444444", "Oscar", "Dalmo", "39", "3512343434", "3512313131", "0+"};
    p5 = new String[]{"5555555", "Petrona", "Lopez", "18", "3512343434", "3512313131", "0+"};
    p6 = new String[]{"6666666", "Laura", "Romero", "28", "3512343434", "3512313131", "0+"};
     */

    public static HashMap<Integer, String[]> circuitoChico = new HashMap<>();
    public static HashMap<Integer, String[]> circuitoMedio = new HashMap<>();
    public static HashMap<Integer, String[]> circuitoAvanzado = new HashMap<>();

    public static void inscribir(HashMap circuito, String[] participante) {
        int key = circuito.size() + 1;
        circuito.put(key, participante);
    }

    public static void mostrarMenu() {
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Bienvenido al sistema de gestion de La Carrera de la Selva");
            System.out.println("\n----------------------------------------------------------");
            System.out.println("1 - Inscribir un participante");
            System.out.println("2 - Mostrar todos los inscriptos en una categoria");
            System.out.println("3 - Desinscribir un participante");
            System.out.println("0 - Salir");
            System.out.print("\nElija una opcion: ");
            int option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1: {
                    System.out.println("En que circuito desea inscribir el nuevo participante?");
                    System.out.println("1 - Circuito chico");
                    System.out.println("2 - Circuito medio");
                    System.out.println("3 - Circuito avanzado");
                    System.out.println("0 - Cancelar");
                    System.out.print("\nElija una opcion: ");
                    int suboption = Integer.parseInt(sc.nextLine());

                    switch (suboption) {
                        case 1: {
                            String entryDatos =
                        }
                    }

                    String[] participante = new String[7];

                    inscribir();
                }
            }
        }
    }


    public static void main(String[] args) {



    }
}
