package ejercicio;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> nombre = new ArrayList<>();
        List<String> apellido = new ArrayList<>();
        List<Integer> edad = new ArrayList<>();
        List<String> dni = new ArrayList<>();
        List<String> celular = new ArrayList<>();
        List<String> numeroEmergencia = new ArrayList<>();
        List<String> grupoSanguineo = new ArrayList<>();

        List<Integer> circuitoChico = new ArrayList<>();
        List<Integer> circuitoMediano = new ArrayList<>();
        List<Integer> circuitoGrande = new ArrayList<>();

        int numeroSiguienteParticipante = 1;

        boolean salir = false;

        Scanner scan = new Scanner(System.in);

        while(!salir) {
            System.out.println("------------------------");
            System.out.println("Seleccione una opcion:");
            System.out.println("1) Agregar nuevo participante.");
            System.out.println("2) Mostrar participantes inscriptos.");
            System.out.println("3) Desinscribir un participante.");
            System.out.println("4) Determinar monto a pagar.");
            System.out.println("5) Salir");
            System.out.println("------------------------");

            int opcion = scan.nextInt();

            if (opcion < 1 || opcion > 5){
                System.out.println("Opción incorrecta.");
                break;
            }

            if (opcion == 5){
                System.out.println("Saliendo del programa.");
                break;
            }

            System.out.println("Seleccione una categoria:");
            System.out.println("1) Circuito chico");
            System.out.println("2) Circuito mediano");
            System.out.println("3) Circuito grande");

            int categoria = scan.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Datos del participante:");
                    System.out.print("Ingrese el nombre: ");
                    nombre.add(scan.next());
                    System.out.print("Ingrese el apellido: ");
                    apellido.add(scan.next());
                    System.out.print("Ingrese la edad: ");
                    edad.add(scan.nextInt());
                    System.out.print("Ingrese el DNI: ");
                    dni.add(scan.next());
                    System.out.print("Ingrese el celular: ");
                    celular.add(scan.next());
                    System.out.print("Ingrese un teléfono de emergencia: ");
                    numeroEmergencia.add(scan.next());
                    System.out.print("Ingrese el grupo sanguineo: ");
                    grupoSanguineo.add(scan.next());

                    switch (categoria) {
                        case 1:
                            circuitoChico.add(numeroSiguienteParticipante);
                            break;
                        case 2:
                            circuitoMediano.add(numeroSiguienteParticipante);
                            break;
                        case 3:
                            circuitoGrande.add(numeroSiguienteParticipante);
                            break;
                    }

                    System.out.println("\nSe inscribió al participante y su número es: " + numeroSiguienteParticipante);
                    numeroSiguienteParticipante++;

                    break;

                case 2:
                    switch (categoria) {
                        case 1:
                            System.out.println("\nInscriptos en categoria de circuito chico:");
                            if (circuitoChico.size() <= 0) {
                                System.out.println("No hay participantes inscriptos en esta categoria.");
                            } else {
                                for (int i = 0; i < circuitoChico.size(); i++) {
                                    int numeroParticipante = circuitoChico.get(i);

                                    System.out.print("Numero: " + numeroParticipante);
                                    System.out.print(" - Nombre: " + nombre.get(numeroParticipante - 1));
                                    System.out.print(" - Apellido: " + apellido.get(numeroParticipante - 1));
                                    System.out.print(" - Edad: " + edad.get(numeroParticipante - 1));
                                    System.out.print(" - DNI: " + dni.get(numeroParticipante - 1));
                                    System.out.print(" - Celular: " + celular.get(numeroParticipante - 1));
                                    System.out.print(" - Nro emergencia: " + numeroEmergencia.get(numeroParticipante - 1));
                                    System.out.print(" - Grupo sanguineo: " + grupoSanguineo.get(numeroParticipante - 1));
                                    System.out.println();
                                }
                            }
                            break;

                        case 2:
                            System.out.println("\nInscriptos en categoria de circuito mediano:");
                            if (circuitoMediano.size() <= 0) {
                                System.out.println("No hay participantes inscriptos en esta categoria.");
                            } else {
                                for (int i = 0; i < circuitoMediano.size(); i++) {
                                    int numeroParticipante = circuitoMediano.get(i);

                                    System.out.print("Numero: " + numeroParticipante);
                                    System.out.print(" - Nombre: " + nombre.get(numeroParticipante - 1));
                                    System.out.print(" - Apellido: " + apellido.get(numeroParticipante - 1));
                                    System.out.print(" - Edad: " + edad.get(numeroParticipante - 1));
                                    System.out.print(" - DNI: " + dni.get(numeroParticipante - 1));
                                    System.out.print(" - Celular: " + celular.get(numeroParticipante - 1));
                                    System.out.print(" - Nro emergencia: " + numeroEmergencia.get(numeroParticipante - 1));
                                    System.out.print(" - Grupo sanguineo: " + grupoSanguineo.get(numeroParticipante - 1));
                                    System.out.println();
                                }
                            }
                            break;

                        case 3:
                            System.out.println("\nInscriptos en categoria de circuito grande:");
                            if (circuitoGrande.size() <= 0) {
                                System.out.println("No hay participantes inscriptos en esta categoria.");
                            } else {
                                for (int i = 0; i < circuitoGrande.size(); i++) {
                                    int numeroParticipante = circuitoGrande.get(i);

                                    System.out.print("Numero: " + numeroParticipante);
                                    System.out.print(" - Nombre: " + nombre.get(numeroParticipante - 1));
                                    System.out.print(" - Apellido: " + apellido.get(numeroParticipante - 1));
                                    System.out.print(" - Edad: " + edad.get(numeroParticipante - 1));
                                    System.out.print(" - DNI: " + dni.get(numeroParticipante - 1));
                                    System.out.print(" - Celular: " + celular.get(numeroParticipante - 1));
                                    System.out.print(" - Nro emergencia: " + numeroEmergencia.get(numeroParticipante - 1));
                                    System.out.print(" - Grupo sanguineo: " + grupoSanguineo.get(numeroParticipante - 1));
                                    System.out.println();
                                }
                                break;
                            }
                    }
                    break;

                case 3:
                    System.out.print("\nIndique número de participante a remover: ");
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
                    }

                    System.out.println("El participante fue removido correctamente.");
                    break;

                case 4:
                    System.out.print("Ingrese la edad: ");
                    int edadParticipante = scan.nextInt();

                    switch (categoria) {
                        case 1:
                            if(edadParticipante < 18)
                                System.out.println("El participante debe abonar $1300.");
                            else
                                System.out.println("El participante debe abonar $1500.");
                            break;
                        case 2:
                            if(edadParticipante < 18)
                                System.out.println("El participante debe abonar $2000.");
                            else
                                System.out.println("El participante debe abonar $2300.");
                            break;
                        case 3:
                            if(edadParticipante < 18)
                                System.out.println("No se puede inscribir a menores de edad en la categoria de circuito grande.");
                            else
                                System.out.println("El participante debe abonar $2800.");
                            break;
                    }
                    break;

                default:
                    break;
            }
        }
    }
}