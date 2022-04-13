package Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CarreraSelva {
    public static void main(String[] args) {
        HashMap<Integer, String> inscripcion = new HashMap<>();
        HashMap<String, Integer> circuitos_mayores = new HashMap<>();
        HashMap<String, Integer> circuitos_menores = new HashMap<>();
        ArrayList<String> circuitos = new ArrayList<>();

        String dni, nombre, apellido, celular, numero_emergencia, grupo_sanguineo, requisitos;
        int nro_inscripcion, edad, valor, opcion;

        Scanner scanner = new Scanner(System.in);

        //Datos de los inscriptos

        nro_inscripcion = 1;
        dni = "40032913";
        nombre = "Angel";
        edad = 32;
        apellido = "Di Maria";
        celular = "5411-4083-2192";
        numero_emergencia = "5411-2039-2401";
        grupo_sanguineo = "40032913";

        requisitos = dni + " - " + apellido + ", " + nombre + "\t" + edad + "\t" + celular + "\t" + numero_emergencia +
                "\t" + grupo_sanguineo;

        //Circuitos

        circuitos.add("Avanzado");
        circuitos.add("Medio");
        circuitos.add("Chico");

        circuitos_mayores.put("Avanzado", 2800);
        circuitos_mayores.put("Medio", 2300);
        circuitos_mayores.put("Chico", 1500);

        circuitos_menores.put("Medio", 2000);
        circuitos_menores.put("Chico", 1300);


        //Menu
        /*
        System.out.println("-----MENU-----");
        System.out.print("1. Anotar participante\n2. Mostrar inscriptos\n3. Desinscribir participante\n4. Salir\n");
        opcion = scanner.nextInt();

        switch (opcion){
            case 1: break;
            case 2: break;
            case 3: break;
            case 4: break;

        }
        */
        //Logica
        System.out.println("-----MENU-----");
        System.out.print("1. Anotar participante\n2. Mostrar inscriptos\n3. Desinscribir participante\n4. Salir\n");
        opcion = scanner.nextInt();






        scanner.close();
    }
}
