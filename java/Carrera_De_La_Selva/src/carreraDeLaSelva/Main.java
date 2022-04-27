package carreraDeLaSelva;

import jdk.jshell.EvalException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> participantesInscriptos = new ArrayList<>();
        HashMap<Integer, String> inscriptosC = new HashMap<Integer, String>();
        HashMap<Integer, String> inscriptosM = new HashMap<Integer, String>();
        HashMap<Integer, String> inscriptosA = new HashMap<Integer, String>();


        // variables
        int cantidadParticipantes; //para el ingreso de total de participantes en la matriz
        String nombre = ""; // para el map participantes inscriptos
        String circuitoAInscribir = "";
        String dni = "";
        String grupoSanguineo = "";
        String celular = "";
        String numEmergencia = "";
        String edad = "";
        int monto = 0;


        // creacion de matriz por participantes
        System.out.println("Ingrese cantidad de participantes");
        cantidadParticipantes = sc.nextInt();
        sc.nextLine(); //necesario para que no me saltee la siguiente linea pidiendo el nombre. Da error cuando nextInt es seguido directamente de nextLine.

        // creo la matriz
        String participante[][] = new String[cantidadParticipantes][7];

        for (int f = 0; f < participante.length; f++) {
            for (int c = 0; c < 5; c++) {
                System.out.println("ingrese su nombre completo");
                nombre = sc.nextLine();
                participante[f][c] = nombre;
                c++;

                System.out.println("ingrese su dni");
                dni = sc.nextLine();
                participante[f][c] = dni;
                c++;

                System.out.println("ingrese su celular");
                celular = sc.nextLine();
                participante[f][c] = celular;
                c++;

                System.out.println("ingrese su grupo sanguineo");
                grupoSanguineo = sc.nextLine();
                participante[f][c] = grupoSanguineo;
                c++;

                System.out.println("ingrese un numero de emergencia");
                numEmergencia = sc.nextLine();
                participante[f][c] = numEmergencia;
                c++;


                System.out.println("ingrese su edad");
                edad = sc.nextLine();
                int edad2 = Integer.parseInt(edad);
                participante[f][c] = edad;
                c++;

                if (edad2 <= 18) {
                    do {
                        System.out.println("ingrese el circuito al que desea inscribirse c, para el corto, m para el medio");
                        circuitoAInscribir = sc.nextLine();
                    } while (!circuitoAInscribir.equalsIgnoreCase("c") && !circuitoAInscribir.equalsIgnoreCase("m"));

                    if (circuitoAInscribir.equalsIgnoreCase("c")) {
                        monto = 1300;
                        inscriptosA.put(f, "Nombre: " + nombre + " DNI  " + dni + " Celular: " + celular + " GrupoSanguineo " + grupoSanguineo + " Numero de Emergencia " + numEmergencia + " Edad " + edad + " Circuito " + circuitoAInscribir);
                    } else {
                        monto = 2000;
                        inscriptosM.put(f, "Nombre: " + nombre + " DNI  " + dni + " Celular: " + celular + " GrupoSanguineo " + grupoSanguineo + " Numero de Emergencia " + numEmergencia + " Edad " + edad + " Circuito " + circuitoAInscribir);

                    }

                } else {

                    do {
                        System.out.println("ingrese el circuito al que desea inscribirse c, para el corto, m para el medio y a para avanzado");
                        circuitoAInscribir = sc.nextLine();
                    } while (!circuitoAInscribir.equalsIgnoreCase("c") && !circuitoAInscribir.equalsIgnoreCase("m") && !circuitoAInscribir.equalsIgnoreCase("a"));

                    switch (circuitoAInscribir) {
                        case "c":
                            monto = 1500;
                            inscriptosC.put(f, "Nombre: " + nombre + " DNI  " + dni + " Celular: " + celular + " GrupoSanguineo " + grupoSanguineo + " Numero de Emergencia " + numEmergencia + " Edad " + edad + " Circuito " + circuitoAInscribir);
                            break;

                        case "m":
                            monto = 2300;
                            inscriptosM.put(f, "Nombre: " + nombre + " DNI  " + dni + " Celular: " + celular + " GrupoSanguineo " + grupoSanguineo + " Numero de Emergencia " + numEmergencia + " Edad " + edad + " Circuito " + circuitoAInscribir);
                            break;

                        case "a":
                            monto = 2800;
                            inscriptosA.put(f, "Nombre: " + nombre + " DNI  " + dni + " Celular: " + celular + " GrupoSanguineo " + grupoSanguineo + " Numero de Emergencia " + numEmergencia + " Edad " + edad + " Circuito " + circuitoAInscribir);
                            break;
                    }
                }

                participante[f][c] = circuitoAInscribir;
                System.out.println("El monto a abonar es " + monto);
                c++;

            }

        }

        int removeParticipante;

        System.out.println("Ingrese el participante a eliminar");
        removeParticipante = sc.nextInt();

        int key;
        String value;


        for (Map.Entry<Integer, String> entry  : inscriptosA.entrySet()  ) {
            System.out.println(inscriptosA);
            key = entry.getKey();
            value = entry.getValue();
            if ( removeParticipante == key){
                inscriptosA.remove(key,value);
            }



        }



        System.out.println(inscriptosC);
        System.out.println(inscriptosA);
        System.out.println(inscriptosM);
    }
}





