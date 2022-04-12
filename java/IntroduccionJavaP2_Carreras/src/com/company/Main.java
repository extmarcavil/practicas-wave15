package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.*;

public class Main {
    static int codigoInscripcion = 1;
    static String carrera_corta="CIRCUITO_CHICO";
    static String carrera_medio="CIRCUITO_MEDIO";
    static String carrera_largo="CIRCUITO_LARGO";
    static List <Map<String,Map<String,String>>> personasDelSistema=new ArrayList<>();
    static List<String> personasCarrera1 = new ArrayList<>();
    static	List<String> personasCarrera2 = new ArrayList<>();
    static List<String> personasCarrera3 = new ArrayList<>();

    public static void main(String[] args) {
	// write your code here
        final Scanner teclado = new Scanner(System.in);
        int opcionElegida = 0;
        String codigoParticipante;

        Map<String,List<String>> carreras = new HashMap<>();
        String  dni, nombre, apellido, edad, celular, numero_de_emergencia, grupo_sanguineo, carrera;


        int opcionCarrera = 0;
        carreras.put("carrera_corta",null);
        carreras.put("carrera_medio",null);
        carreras.put("carrera_largo",null);

        while (opcionElegida != 5) {
            System.out.println("Introduce el numero de la opci�n que quieras:");
            System.out.println("1.- Inscribir a un nuevo participante en una categoria");
            System.out.println("2.- Mostrar en pantalla los incriptos de cada categoria");
            System.out.println("3.- Desinscribir participantes de una categoria");
            System.out.println("4.- Monto a abonar por cada participante");
            System.out.println("5.- Salir");
            opcionElegida = teclado.nextInt();

            switch (opcionElegida) {
                case 1:
                    Map<String, Map<String, String>> perticipante = new HashMap<>();

                    Map<String, String> datosPersonas = new HashMap<>();

                    System.out.println("Ingrese el dni de la persona ");
                    dni = teclado.next();
                    if(exitePersonaRegistrada(dni)) {
                        System.out.println("Ya existe la persona en una carrera");
                    }else {

                        System.out.println("Ingrese el nombre de la persona ");
                        nombre = teclado.next();
                        datosPersonas.put("Nombre", nombre);
                        System.out.println("Ingrese el apellido de la persona ");
                        apellido = teclado.next();
                        datosPersonas.put("Apellido", apellido);
                        System.out.println("Ingrese la edad de la persona ");
                        edad = teclado.next();
                        datosPersonas.put("Edad",edad);
                        System.out.println("Ingrese el celular de la persona ");
                        celular = teclado.next();
                        datosPersonas.put("Celular",celular);
                        System.out.println("Ingrese un celular de emergencia de la persona ");
                        numero_de_emergencia = teclado.next();
                        datosPersonas.put("numero_de_emergencia", numero_de_emergencia);
                        System.out.println("Ingrese el grupo sanguineo de la persona ");
                        grupo_sanguineo = teclado.next();
                        datosPersonas.put("grupo_sanguineo", grupo_sanguineo);
                        datosPersonas.put("codigo-inscripcion", String.valueOf(codigoInscripcion));

                        codigoInscripcion++;

                        perticipante.put(String.valueOf(dni), datosPersonas);

                        personasDelSistema.add(perticipante);
                    }

                   // Map<String,Map<String,String>> persona=crearPersonas();
                    System.out.println("Ingrese 1, 2 o 3 dependiendo de la carrera a la que se quiere inscribir la persona: opcion 1: Carrera corta, Opcion 2: carrera Media, Opcion 3: Carrera avanzada ");

                    opcionCarrera = teclado.nextInt();

                    if (opcionCarrera == 1){
                        System.out.println();
                        for (Map.Entry<String, Map<String, String>> entry : perticipante.entrySet()) {
                            System.out.println(entry.getKey());
                            personasCarrera1.add(entry.getKey());
                        }
                        carreras.put(carrera_corta, personasCarrera1);


                    } else {
                        if (opcionCarrera == 2) {
                            for (Map.Entry<String, Map<String, String>> entry : perticipante.entrySet()) {
                                System.out.println(entry.getKey());
                                personasCarrera2.add(entry.getKey());
                            }
                            carreras.put(carrera_medio, personasCarrera2);
                        } else {
                            for (Map.Entry<String, Map<String, String>> entry : perticipante.entrySet()) {
                                System.out.println(entry.getKey());
                                personasCarrera3.add(entry.getKey());
                            }
                            carreras.put(carrera_medio, personasCarrera3);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Ingrese 1, 2 o 3 dependiendo de la carrera que quiere visualizar: opcion 1: Carrera corta, Opcion 2: carrera Media, Opcion 3: Carrera avanzada ");
                    opcionCarrera = teclado.nextInt();
                    if (opcionCarrera == 1){
                        mostarDatosInscriptos(carreras,carrera_corta);

                    } else {
                        if (opcionCarrera == 2) {
                            mostarDatosInscriptos(carreras,carrera_medio);

                        } else if(opcionCarrera == 3){
                            mostarDatosInscriptos(carreras,carrera_medio);

                        }else {
                            System.out.println("La carrera seleccionada no existe");

                        }
                    }
                    break;
                case 3:
                    System.out.println("Introduce el dni de la persona que quieres Desinscribir:");
                    String dniAux = teclado.next();
                    personasCarrera1.remove(dniAux);
                    personasCarrera2.remove(dniAux);
                    personasCarrera3.remove(dniAux);

                    System.out.println(" La persona fue desinscripta:");
                    break;
                case 4:
                    System.out.println("Introduce el dni de la persona que quiere abonar");
                    String dniPrecio = teclado.next();
                    calulcarPrecioPorCarreraPorPersona(dniPrecio);
                    break;   // Si la opcion es 5 no se hace nada
                case 5:
                    System.out.println("chau");
                    break;
                default:
                    System.out.println("Tienes que introducir una opci�n valida");
            }

        }
    }
    public static void calulcarPrecioPorCarreraPorPersona(String dni) {
        for (String dniCarrera : personasCarrera1) {
            if(dni.equals(dniCarrera)) {
                mostarMontoAPagar(dniCarrera,carrera_corta);

            }
        }

        for (String dniCarrera : personasCarrera2) {
            if(dni.equals(dniCarrera)) {
                mostarMontoAPagar(dniCarrera,carrera_medio);

            }
        }


        for (String dniCarrera : personasCarrera3) {
            if(dni.equals(dniCarrera)) {
                mostarMontoAPagar(dniCarrera,carrera_largo);
            }
        }

    }

    public static void mostarMontoAPagar(String dni,String carrera) {
        for ( Map<String,Map<String,String>> persona: personasDelSistema) {
            for (Entry<String, Map<String, String>> entryDos : persona.entrySet()) {
                String key = entryDos.getKey();
                if(key.equals(dni)) {

                    for (Map.Entry<String, String> entry : entryDos.getValue().entrySet()) {
                        if (entry.getKey().equals("Edad")) {
                            if(Integer.parseInt(entry.getValue())>=18) {
                                if(carrera.equals(carrera_corta)) {
                                    System.out.println("Abona:"+ 1500);
                                }else if(carrera.equals(carrera_medio)) {
                                    System.out.println("Abona:"+ 2300);
                                }else {
                                    System.out.println("Abona:"+ 2800);

                                }

                            }else {
                                if(carrera.equals(carrera_corta)) {
                                    System.out.println("Abona:"+ 1300);
                                }else if(carrera.equals(carrera_medio)) {
                                    System.out.println("Abona:"+ 2000);
                                }
                            }

                        }
                    }
                }
            }

        }
    }
    public static Map<String,Map<String,String>> crearPersonas() {
        String dni="";
        if(exitePersonaRegistrada(dni)) {
            System.out.println("Ya existe la persona en una carrera");
            return null;
        }else {
            Map<String,Map<String,String>> perticipante = new HashMap<>();

            Map<String, String> datosPersonas = new HashMap<>();
            datosPersonas.put("Nombre", "nom1"+codigoInscripcion);
            datosPersonas.put("Apellido", "ape1"+codigoInscripcion);
            datosPersonas.put("Edad", String.valueOf(16+codigoInscripcion));
            datosPersonas.put("codigoInscripcion",String.valueOf(codigoInscripcion));
            perticipante.put(String.valueOf(123+codigoInscripcion),datosPersonas);
            codigoInscripcion++;
            personasDelSistema.add(perticipante);
            return perticipante;

        }

    }

    public static boolean exitePersonaRegistrada(String dni) {
        boolean existe=false;
        for ( Map<String,Map<String,String>> persona: personasDelSistema) {
            for (Entry<String, Map<String, String>> entryDos : persona.entrySet()) {
                String key = entryDos.getKey();
                if(key.equals(dni)) {
                    existe=true;
                }
            }
        }

        return existe;
    }

    public static void mostarDatosInscriptos(Map<String,List<String>> carreras,String tipoDeCarrera) {
        for (Entry<String, List<String>> entry : carreras.entrySet()) {
            if (entry.getKey().equals(tipoDeCarrera)) {
                List<String> dnisCarreras=entry.getValue();
                for (String dni: dnisCarreras) {
                    System.out.println("==>>"+dni);
                    for (int i = 0; i < personasDelSistema.size(); i++) {
                        //Map<String, Map<String, String>> datos=personasDelSistema.get(i);
                        for (Map.Entry<String, Map<String, String>> e :personasDelSistema.get(i).entrySet()) {
                            String keyDNI=e.getKey();
                            if(keyDNI.equals(dni)) {
                                for (Map.Entry<String, String> entrada : e.getValue().entrySet()) {
                                    String key = entrada.getKey();
                                    String val = entrada.getValue();
                                    System.out.println(key +"--"+val);

                                }
                            }
                        }

                    }
                }

            }
        }
    }
}
