import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Map<String, String>> circuitoChico = new ArrayList<>();
        List<Map<String, String>> circuitoMedio = new ArrayList<>();
        List<Map<String, String>> circuitoAvanzado = new ArrayList<>();

        int nroDeParticipantes = 0;

        boolean continuarPrograma = true;

        System.out.println("---> Bienvenido a la Carrera de la Selva <---");
        System.out.println();

        Scanner entrada = new Scanner(System.in);

        while (continuarPrograma) {
            System.out.println("Ingrese un número de opción: ");
            System.out.println("1 - Inscripción de participantes");
            System.out.println("2 - Mostrar a los participantes inscriptos en cada categoría");
            System.out.println("3 - Cancelar una inscripción");
            System.out.println("4 - Salir");

            switch (entrada.next()) {
                case "1":
                    nroDeParticipantes = inscripcionParticipante(entrada, nroDeParticipantes, circuitoChico, circuitoMedio, circuitoAvanzado);
                    break;
                case "2":
                    mostrarInscriptos(circuitoChico, circuitoMedio, circuitoAvanzado);
                    break;
                case "3":
                    System.out.println("Indique la categoría a la cual el participante se encuentra inscripto:");
                    System.out.println("Categoría 'Circuito Chico' ingrese 1");
                    System.out.println("Categoría 'Circuito Medio' ingrese 2");
                    System.out.println("Categoría 'Circuito Avanzado' ingrese 3");

                    switch (entrada.next()) {
                        case "1":
                            circuitoChico = eliminarParticipante(entrada, circuitoChico);
                            break;
                        case "2":
                            circuitoMedio = eliminarParticipante(entrada, circuitoMedio);
                            break;
                        case "3":
                            circuitoAvanzado = eliminarParticipante(entrada, circuitoAvanzado);
                            break;
                        default:
                            System.out.println("No se ha podido completar la solicitud de desinscripción");
                    }
                    break;
                case "4":
                    continuarPrograma = false;
                    break;
            }
        }
    }

    private static int inscripcionParticipante(Scanner entrada, int nroDeParticipantes, List<Map<String, String>> circuitoChico,
                                                List<Map<String, String>> circuitoMedio, List<Map<String, String>> circuitoAvanzado)
        {
            System.out.println("A continuación le pediremos sus datos para comenzar la inscripción");
            System.out.println();
            boolean continuarInscripcion = false;
            double montoAAbonar = 0;

            do {
                Map<String, String> participante = new HashMap<>();
                nroDeParticipantes++;
                participante.put("id", String.valueOf(nroDeParticipantes));

                System.out.println("Ingrese numero de dni: ");
                participante.put("dni", entrada.next());

                System.out.println("Ingrese nombre");
                participante.put("nombre", entrada.next());

                System.out.println("Ingrese apellido:");
                participante.put("apellido", entrada.next());

                System.out.println("Ingrese edad");
                participante.put("edad", entrada.next());

                System.out.println("Ingrese telefono");
                participante.put("telefono", entrada.next());

                System.out.println("Ingrese numero de emergencia");
                participante.put("numeroEmergencia", entrada.next());

                System.out.println("Ingrese grupo sanguineo");
                participante.put("grupoSanguineo", entrada.next());

                System.out.println("¿En qué categoría quiere participar?");
                System.out.println("Para categoría 'Circuito Chico' ingrese 1");
                System.out.println("Para categoría 'Circuito Medio' ingrese 2");
                System.out.println("Para categoría 'Circuito Avanzado' ingrese 3 (Solo para mayores de 18 años!)");

                switch (entrada.next()) {
                    case "1":
                        circuitoChico.add(participante);
                        if (Integer.parseInt(participante.get("edad")) < 18)
                            montoAAbonar = 1300;
                        else
                            montoAAbonar = 1500;
                        break;
                    case "2":
                        circuitoMedio.add(participante);
                        if (Integer.parseInt(participante.get("edad")) < 18)
                            montoAAbonar = 2000;
                        else
                            montoAAbonar = 2300;
                        break;
                    case "3":
                        circuitoAvanzado.add(participante);
                        montoAAbonar = 2800;
                        break;
                    default:
                        System.out.println("No se pudo registrar al participante");
                        break;
                }

                System.out.println("El monto a abonar es de: $" + montoAAbonar);
                System.out.println();

                System.out.println("¿Desea realizar otra inscripcion? (Ingrese Si/No)");
                if (entrada.next().equals("Si"))
                    continuarInscripcion = true;
                else
                    continuarInscripcion = false;
            } while (continuarInscripcion);

            return nroDeParticipantes;
        }

        private static void mostrarInscriptos(List<Map<String, String>> circuitoChico, List<Map<String, String>> circuitoMedio,
                                      List<Map<String, String>> circuitoAvanzado) {
            System.out.println("Inscriptos en Circuito Chico:");
            mostrarCircuito(circuitoChico);
            System.out.println("Inscriptos en Circuito Medio:");
            mostrarCircuito(circuitoMedio);
            System.out.println("Inscriptos en Circuito Avanzado:");
            mostrarCircuito(circuitoAvanzado);
        }

        private static void mostrarCircuito(List<Map<String, String>> circuito) {
            for (int i = 0; i < circuito.size(); i++) {
                System.out.println("Inscripcion Nº " + circuito.get(i).get("id"));
                System.out.println("Dni: " + circuito.get(i).get("dni"));
                System.out.println("Nombre: " + circuito.get(i).get("nombre"));
                System.out.println("Apellido: " + circuito.get(i).get("apellido"));
                System.out.println("Edad: " + circuito.get(i).get("edad"));
                System.out.println("Telefono: " + circuito.get(i).get("telefono"));
                System.out.println("Número de emergencia: " + circuito.get(i).get("numeroEmergencia"));
                System.out.println("Grupo Sanguíneo: " + circuito.get(i).get("grupoSanguineo"));
                System.out.println();
            }
        }

        private static List<Map<String, String>> eliminarParticipante(Scanner entrada, List<Map<String, String>> circuito) {
            System.out.println("Ingrese el número de inscripción del participante: ");
            String numeroInscripcion = entrada.next();
            for(Map<String, String> participante: circuito) {
                if (participante.get("id").equals(numeroInscripcion)) {
                    circuito.remove(participante);
                    System.out.println("Se ha cancelado la inscripcion Nº " + numeroInscripcion + " exitosamente");
                    return circuito;
                }
            }
            System.out.println("Lo lamento, no se pudo cancelar la inscripción Nº " + numeroInscripcion + "intente nuevamente");

            return circuito;
        }
}
