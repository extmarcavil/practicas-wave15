import java.util.*;

public class Main {

    private static String calcularMontoAPagar(int edad, int circuito) {
        String montoAPagar = "";

        if ((circuito != 1 && circuito != 2 && circuito != 3) || (edad < 0 || edad > 90)) return montoAPagar;

        switch (circuito) {
            case 1:
                if (edad < 18) {
                    montoAPagar = "1300";
                } else {
                    montoAPagar = "1500";
                }
                break;
            case 2:
                if (edad < 18) {
                    montoAPagar = "2000";
                } else {
                    montoAPagar = "2300";
                }
                break;
            case 3:
                if (edad >= 18) {
                    montoAPagar = "2800";
                }
                break;
        }

        return montoAPagar;
    }


    private static Map<String, String> crearParticipante(String nombre,
                                                         String apellido,
                                                         String dni,
                                                         int edad,
                                                         String celular,
                                                         String numeroEmergencia,
                                                         String grupoSanguineo,
                                                         int circuito,
                                                         int numeroParticipante) {
        String montoAPagar = calcularMontoAPagar(edad, circuito);
        Map<String, String> participante = null;
        if (!montoAPagar.equals("")) {
            participante = new HashMap<>();
            participante.put("nombre", nombre);
            participante.put("apellido", apellido);
            participante.put("dni", dni);
            participante.put("edad", Integer.toString(edad));
            participante.put("celular", celular);
            participante.put("numeroEmergencia", numeroEmergencia);
            participante.put("grupoSanguineo", grupoSanguineo);
            participante.put("circuito", Integer.toString(circuito));
            participante.put("numeroParticipante", Integer.toString(numeroParticipante));
            participante.put("montoAPagar", montoAPagar);
        }

        return participante;
    }

    private static void mostrarMenu() {
        System.out.println("\t\tCarrera de la Selva\n");
        System.out.println("-----------------------------------\n");
        System.out.println("1: Ingresar participante\n" +
                "2: Ver participantes por categoría\n" +
                "3: Remover participante\n" +
                "4: Mostrar monto a abonar\n" +
                "5: Salir\n");
    }

    private static Map<String, String> buscarParticipante(int numeroParticipante, List<Map<String, String>> participantes) {
        for (Map<String, String> participante : participantes) {
            if (Integer.parseInt(participante.get("numeroParticipante")) == numeroParticipante) {
                return participante;
            }
        }
        return null;
    }

    private static void mostrarParticipante(Map<String, String> participante) {
        Set<Map.Entry<String, String>> propiedades = participante.entrySet();
        for (Map.Entry<String, String> propiedad : propiedades) {
            System.out.println(propiedad.getKey() + " : " + propiedad.getValue());
        }
        System.out.println();
    }

    private static void mostrarParticipantes(List<Map<String, String>> participantes) {
        if (participantes.size() == 0) {
            System.out.println("No hay participantes en esta categoria\n");
        } else {
            for (Map<String, String> participante : participantes) {
                mostrarParticipante(participante);
                System.out.println("\n---------------------------------------");
            }
        }
    }


    public static void main(String[] args) {
        int numeroParticipante = 1;
        Scanner input = new Scanner(System.in);
        List<Map<String, String>> participantesTodos = new ArrayList<>();
        List<Map<String, String>> participantesCircuitoChico = new ArrayList<>();
        List<Map<String, String>> participantesCircuitoMedio = new ArrayList<>();
        List<Map<String, String>> participantesCircuitoAvanzado = new ArrayList<>();
        Map<String, String> participante;
        boolean ejecutando = true;

        while (ejecutando) {
            mostrarMenu();

            int opcion = input.nextInt();
            input.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre: ");
                    String nombre = input.nextLine();
                    System.out.print("Ingrese el apellido: ");
                    String apellido = input.nextLine();
                    System.out.print("Ingrese el documento: ");
                    String dni = input.nextLine();
                    System.out.print("Ingrese la edad: ");
                    int edad = input.nextInt();
                    input.nextLine();
                    System.out.print("Ingrese el celular: ");
                    String celular = input.nextLine();
                    System.out.print("Ingrese el numero de emergencia: ");
                    String numeroEmergencia = input.nextLine();
                    System.out.print("Ingrese el grupo sanguineo: ");
                    String grupoSanguineo = input.nextLine();
                    System.out.println("Ingrese el circuito al que se inscribe:\n" +
                            "1) Circuito chico\n" +
                            "2) Circuito medio\n" +
                            "3) Circuito avanzado\n");
                    int circuito = input.nextInt();
                    input.nextLine();

                    participante = crearParticipante(nombre, apellido, dni, edad, celular, numeroEmergencia, grupoSanguineo, circuito, numeroParticipante);

                    if (participante != null) {
                        participantesTodos.add(participante);
                        switch (circuito) {
                            case 1:
                                participantesCircuitoChico.add(participante);
                                break;
                            case 2:
                                participantesCircuitoMedio.add(participante);
                                break;
                            case 3:
                                participantesCircuitoAvanzado.add(participante);
                                break;
                        }
                        System.out.println("Participante " + numeroParticipante + " agregado correctamente\n");
                        numeroParticipante++;
                    }
                    break;
                case 2:
                    System.out.println("Ingrese la categoria:\n" +
                            "1) Circuito chico\n" +
                            "2) Circuito medio\n" +
                            "3) Circuito avanzado\n");
                    opcion = input.nextInt();
                    input.nextLine();
                    switch (opcion) {
                        case 1:
                            mostrarParticipantes(participantesCircuitoChico);
                            break;
                        case 2:
                            mostrarParticipantes(participantesCircuitoChico);
                            break;
                        case 3:
                            mostrarParticipantes(participantesCircuitoChico);
                            break;
                        default:
                            System.out.println("Opcion invalida\n");
                            break;
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el numero del participante: ");
                    opcion = input.nextInt();
                    input.nextLine();
                    participante = buscarParticipante(opcion, participantesTodos);
                    if (participante != null) {
                        switch (Integer.parseInt(participante.get("circuito"))) {
                            case 1:
                                participantesCircuitoChico.remove(participante);
                                break;

                            case 2:
                                participantesCircuitoMedio.remove(participante);
                                break;

                            case 3:
                                participantesCircuitoAvanzado.remove(participante);
                                break;
                        }
                        participantesTodos.remove(participante);
                        System.out.println("Participante eliminado\n");
                    } else {
                        System.out.println("No se encontro al participante\n");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el numero del participante: ");
                    opcion = input.nextInt();
                    input.nextLine();
                    participante = buscarParticipante(opcion, participantesTodos);
                    if (participante != null) {
                        System.out.println("El participante debe abonar $" + participante.get("montoAPagar"));
                    }
                    break;
                case 5:
                    ejecutando = false;
                    break;
                default:
                    System.out.println("Opcion invalida\n");
                    break;
            }
        }
        input.close();
    }
}
