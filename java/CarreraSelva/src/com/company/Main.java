package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static int dni=0;
    static String nombre="";
    static String apellido="";
    static int edad=0;
    static String celular="";
    static String numEmergencia="";
    static String grupoSanguineo="";
    static Scanner teclado = new Scanner(System.in);

    public static void ingresoDatos(){
        System.out.println("Ingrese el DNI:");
        dni=Integer.parseInt(teclado.nextLine());
        System.out.println("Ingrese el Nombre:");
        nombre=teclado.nextLine();
        System.out.println("Ingrese el apellido:");
        apellido=teclado.nextLine();
        System.out.println("Ingrese el celular:");
        celular=teclado.nextLine();
        System.out.println("Ingrese el Numero de Emergencia:");
        numEmergencia=teclado.nextLine();
        System.out.println("Ingrese el Grupo Sanguineo:");
        grupoSanguineo=teclado.nextLine();
    }

    public static void main(String[] args) {
        //ArrayList<String> participantes = new ArrayList<String>();
        Map<Integer,String> chico = new HashMap<Integer,String>();
        Map<Integer,String> medio = new HashMap<Integer,String>();
        Map<Integer,String> avanzado = new HashMap<Integer,String>();
        int accion;
        System.out.println("Usted puede realizar las siguientes acciones:");
        System.out.println("1 - Nueva Inscripcion");
        System.out.println("2 - Listar Inscriptos por categoria");
        System.out.println("3 - Desinscribir Participante");
        System.out.println("4 - Salir");
        System.out.println("Ingrese 1,2,3,4");
        accion=Integer.parseInt(teclado.nextLine());
        while (accion!=4){
            switch (accion){
                case 1:
                    System.out.println("Cual es su edad? ");
                    edad=Integer.parseInt(teclado.nextLine());
                    String opcion;
                    int nroParticipante=0;
                    if(edad<18){
                        ingresoDatos();
                        System.out.println("Usted puede inscribirse a:");
                        System.out.println("A - Chico");
                        System.out.println("B - Medio");
                        System.out.println("Ingrese A o B:");
                        opcion=teclado.nextLine();
                        switch (opcion){
                            case "A":
                                chico.put(nroParticipante,dni+" "+nombre+" "+apellido+" "+edad+" "+celular+" "+numEmergencia+" "+grupoSanguineo);
                                break;
                            case "B":
                                medio.put(nroParticipante,dni+" "+nombre+" "+apellido+" "+edad+" "+celular+" "+numEmergencia+" "+grupoSanguineo);
                                break;
                        }
                        nroParticipante++;
                    }else{
                        ingresoDatos();
                        System.out.println("Usted puede inscribirse a:");
                        System.out.println("A - Chico");
                        System.out.println("B - Medio");
                        System.out.println("C - Avanzado");

                        System.out.println("Ingrese A, B, C:");
                        opcion=teclado.nextLine();
                        while (!(opcion.equals("A") || opcion.equals("B") || opcion.equals("C"))){
                            System.out.println("Usted puede inscribirse a:");
                            System.out.println("A - Chico");
                            System.out.println("B - Medio");
                            System.out.println("C - Avanzado");
                            opcion=teclado.nextLine();
                        }
                        switch (opcion){
                            case "A":
                                chico.put(nroParticipante,dni+" "+nombre+" "+apellido+" "+edad+" "+celular+" "+numEmergencia+" "+grupoSanguineo);
                                if(edad >= 18){
                                    System.out.println("Debe pagar $1500");
                                }else{
                                    System.out.println("Debe pagar $1300");
                                }
                                break;
                            case "B":
                                medio.put(nroParticipante,dni+" "+nombre+" "+apellido+" "+edad+" "+celular+" "+numEmergencia+" "+grupoSanguineo);
                                if(edad >= 18){
                                    System.out.println("Debe pagar $2000");
                                }else{
                                    System.out.println("Debe pagar $2300");
                                }
                                break;
                            case "C":
                                avanzado.put(nroParticipante,dni+" "+nombre+" "+apellido+" "+edad+" "+celular+" "+numEmergencia+" "+grupoSanguineo);
                                System.out.println("Debe pagar $2800");

                                break;
                            default:
                                System.out.println("Ingrese una opcion valida!");
                                break;

                        }
                        nroParticipante++;
                    }
                    break;
                case 2:
                    System.out.println("Que categoria desea listar?");
                    System.out.println("A - Chico");
                    System.out.println("B - Medio");
                    System.out.println("C - Avanzado");
                    String opcionListar=teclado.nextLine();
                    switch (opcionListar){
                        case "A":
                            System.out.println("Listado de Participantes de la categoria Chico:");
                            for(Map.Entry participante : chico.entrySet()){
                                System.out.print(participante.getKey() + "\t");
                                System.out.println(participante.getValue());
                            }
                            break;
                        case "B":
                            System.out.println("Listado de Participantes de la categoria Medio:");

                            for(Map.Entry participante : medio.entrySet()){
                                System.out.print(participante.getKey() + "\t");
                                System.out.println(participante.getValue());
                            }
                            break;
                        case "C":
                            System.out.println("Listado de Participantes de la categoria Avanzado:");

                            for(Map.Entry participante : avanzado.entrySet()){
                                System.out.print(participante.getKey() + "\t");
                                System.out.println(participante.getValue());
                            }
                            break;
                    }

                    break;
                case 3:
                    System.out.println("Ingrese nro de la persona a desinscribir");
                    int nro = Integer.parseInt(teclado.nextLine());

                    for (Map.Entry part : chico.entrySet()){
                        if (Integer.parseInt(part.getKey().toString())==nro){
                            chico.remove(nro);
                            System.out.println("Se eliminó participante de circuito chico");
                        }
                    }
                    for (Map.Entry part : medio.entrySet()){
                        if (Integer.parseInt(part.getKey().toString())==nro){
                            medio.remove(nro);
                            System.out.println("Se eliminó participante de circuito medio");
                        }
                    }
                    for (Map.Entry part : avanzado.entrySet()){
                        if (Integer.parseInt(part.getKey().toString())==nro){
                            avanzado.remove(nro);
                            System.out.println("Se eliminó participante de circuito avanzado");
                        }else{
                            System.out.println("No esta registrado el participante3");
                        }
                    }
                    break;
                case 4:
                    break;
                default:

                    break;

            }
            System.out.println("Usted puede realizar las siguientes acciones:");
            System.out.println("1 - Nueva Inscripcion");
            System.out.println("2 - Listar Inscriptos por categoria");
            System.out.println("3 - Desinscribir Participante");
            System.out.println("4 - Salir");
            System.out.println("Ingrese 1,2,3,4");
            accion=Integer.parseInt(teclado.nextLine());
        }




    }
}

