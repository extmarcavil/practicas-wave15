package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //se me ocurrio que podria usar un Map<String, String> para modelar a la persona
        // no lo codifico porque esta funcionando y tendria que cambiar el codigo completo
        List<String> nombres = new ArrayList<>();
        List<String> apellidos = new ArrayList<>();
        List<Integer> edades = new ArrayList<>();
        List<String> dnis = new ArrayList<>();
        List<String> celulares = new ArrayList<>();
        List<String> numerosEmergencia = new ArrayList<>();
        List<String> gruposSanguineos = new ArrayList<>();

        List<Integer> circuitoChico = new ArrayList<>();
        List<Integer> circuitoMediano = new ArrayList<>();
        List<Integer> circuitoGrande = new ArrayList<>();

        int numeroParticipanteSiguiente = 1;
        boolean salir = false;

        Scanner scan = new Scanner(System.in);

        //hay mucha repeticion de logica porque no queria extraerla en metodos, pensando que no era el alcance de este ejercicio

        while(!salir) {
            System.out.println("Seleccione una opcion:");
            System.out.println("\t 1) Agregar participante");
            System.out.println("\t 2) Mostrar Inscriptos");
            System.out.println("\t 3) Desinscribir un participante");
            System.out.println("\t 4) Determinar monto");

            int opcion = scan.nextInt();

            System.out.println("Seleccione una categoria:");
            System.out.println("\t 1) Circuito chico");
            System.out.println("\t 2) Circuito mediano");
            System.out.println("\t 3) Circuito grande");

            int categoria = scan.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Indique el nombre: ");
                    nombres.add(scan.next());
                    System.out.print("Indique el apellido: ");
                    apellidos.add(scan.next());
                    System.out.print("Indique la edad: ");
                    edades.add(scan.nextInt());
                    System.out.print("Indique el dni: ");
                    dnis.add(scan.next());
                    System.out.print("Indique el celular: ");
                    celulares.add(scan.next());
                    System.out.print("Indique un telefono de emergencia: ");
                    numerosEmergencia.add(scan.next());
                    System.out.print("Indique el grupo sanguineo: ");
                    gruposSanguineos.add(scan.next());

                    switch (categoria) {
                        case 1:
                            circuitoChico.add(numeroParticipanteSiguiente);
                            break;
                        case 2:
                            circuitoMediano.add(numeroParticipanteSiguiente);
                            break;
                        case 3:
                            circuitoGrande.add(numeroParticipanteSiguiente);
                            break;
                    }

                    System.out.println("El participante ha sido inscripto correctamente, su numero es:" + numeroParticipanteSiguiente);
                    numeroParticipanteSiguiente++;
                    break;
                case 2:
                    switch (categoria) {
                        case 1:
                            System.out.println("Los inscriptos en la categoria de circuito chico son:");
                            for (int i = 0; i < circuitoChico.size(); i++) {
                                int numeroParticipante = circuitoChico.get(i);

                                System.out.print(numeroParticipante + ") ");
                                System.out.print(nombres.get(numeroParticipante - 1));
                                System.out.print(" ");
                                System.out.print(apellidos.get(numeroParticipante - 1));
                                System.out.print(" ");
                                System.out.print(edades.get(numeroParticipante - 1));
                                System.out.print(" ");
                                System.out.print(dnis.get(numeroParticipante - 1));
                                System.out.print(" ");
                                System.out.print(celulares.get(numeroParticipante - 1));
                                System.out.print(" ");
                                System.out.print(numerosEmergencia.get(numeroParticipante - 1));
                                System.out.print(" ");
                                System.out.print(gruposSanguineos.get(numeroParticipante - 1));
                                System.out.println();
                            }
                            break;
                        case 2:
                            System.out.println("Los inscriptos en la categoria de circuito mediano son:");
                            for (int i = 0; i < circuitoMediano.size(); i++) {
                                int numeroParticipante = circuitoMediano.get(i);

                                System.out.print(numeroParticipante + ") ");
                                System.out.print(nombres.get(numeroParticipante - 1));
                                System.out.print(" ");
                                System.out.print(apellidos.get(numeroParticipante - 1));
                                System.out.print(" ");
                                System.out.print(edades.get(numeroParticipante - 1));
                                System.out.print(" ");
                                System.out.print(dnis.get(numeroParticipante - 1));
                                System.out.print(" ");
                                System.out.print(celulares.get(numeroParticipante - 1));
                                System.out.print(" ");
                                System.out.print(numerosEmergencia.get(numeroParticipante - 1));
                                System.out.print(" ");
                                System.out.print(gruposSanguineos.get(numeroParticipante - 1));
                                System.out.println();
                            }
                            break;
                        case 3:
                            System.out.println("Los inscriptos en la categoria de circuito grande son:");
                            for (int i = 0; i < circuitoGrande.size(); i++) {
                                int numeroParticipante = circuitoGrande.get(i);

                                System.out.print(numeroParticipante + ") ");
                                System.out.print(nombres.get(numeroParticipante - 1));
                                System.out.print(" ");
                                System.out.print(apellidos.get(numeroParticipante - 1));
                                System.out.print(" ");
                                System.out.print(edades.get(numeroParticipante - 1));
                                System.out.print(" ");
                                System.out.print(dnis.get(numeroParticipante - 1));
                                System.out.print(" ");
                                System.out.print(celulares.get(numeroParticipante - 1));
                                System.out.print(" ");
                                System.out.print(numerosEmergencia.get(numeroParticipante - 1));
                                System.out.print(" ");
                                System.out.print(gruposSanguineos.get(numeroParticipante - 1));
                                System.out.println();
                            }
                            break;
                    }
                    break;
                case 3:
                    System.out.print("Indique el numero de participante a remover: ");
                    int participante = scan.nextInt();

                    switch (categoria) {
                        case 1:
                            circuitoChico.remove(participante-1);
                            break;
                        case 2:
                            circuitoMediano.remove(participante-1);
                            break;
                        case 3:
                            circuitoGrande.remove(participante-1);
                            break;
                    }//aca hay un bug que intenta eliminar al numero de indice en vez de al participante
                    //lo solucionaria utilizando strings y parseandolo a int para buscar en los atributos

                    System.out.println("El participante ha sido removido correctamente");
                    break;
                case 4:
                    System.out.print("Indique la edad: ");
                    int edad = scan.nextInt();

                    switch (categoria) {
                        case 1:
                            if(edad < 18)
                                System.out.println("El participante debera abonar $1300");
                            else
                                System.out.println("El participante debera abonar $1500");
                            break;
                        case 2:
                            if(edad < 18)
                                System.out.println("El participante debera abonar $2000");
                            else
                                System.out.println("El participante debera abonar $2300");
                            break;
                        case 3:
                            if(edad < 18)
                                System.out.println("No se admite al participante en esta categoria");
                            else
                                System.out.println("El participante debera abonar $2800");
                            break;
                    }
                    break;
                default:
                    salir = true;
            }

        }

    }
}
