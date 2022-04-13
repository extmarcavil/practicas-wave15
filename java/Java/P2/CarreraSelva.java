package Java.P2;

import java.util.*;

public class CarreraSelva {

    private static void mostrarMenu() {
        System.out.println("REQUISITO: Para la categoría C el participante debe tener 18 años o más");
        System.out.println("1 - Agregar Participante");
        System.out.println("2 - Desinscribir Participante");
        System.out.println("3 - Mostrar Inscriptos");
        System.out.println("4 - Salir");
        System.out.println();
        System.out.print("Seleccione una opción: ");
    }

    private static void mostrarCategoria() {
        System.out.println("Elegir Categoría");
        System.out.println("A - Circuito Chico");
        System.out.println("B - Circuiro Medio");
        System.out.println("C - Circuito Avanzado");
    }

    private static Map<String, String> datosParticipante() {
        Map<String, String> datos = new HashMap();

        Scanner input = new Scanner(System.in);

        System.out.print("DNI: ");
        datos.put("DNI", input.next());

        System.out.print("Nombre: ");
        datos.put("Nombre", input.next());

        System.out.print("Apellido: ");
        datos.put("Apellido", input.next());

        System.out.print("Edad: ");
        datos.put("Edad", input.next());

        System.out.print("Celular: ");
        datos.put("Celular", input.next());

        System.out.print("Teléfono de Emergencia: ");
        datos.put("Emergencia", input.next());

        System.out.print("Grupo Sanguíneo: ");
        datos.put("Sanguineo", input.next());

        return datos;
    }

    private static void mostrarInscriptos(Map<Integer, Map<String, String>> categoria) {
        for (Map.Entry<Integer, Map<String, String>> entry : categoria.entrySet()) {
            System.out.println("Número de inscripción: " + entry.getKey());
            System.out.println("DNI: " + entry.getValue().get("DNI"));
            System.out.println("Nombre: " + entry.getValue().get("Nombre"));
            System.out.println("Apellido: " +entry.getValue().get("Apellido"));
            System.out.println("Edad: " + entry.getValue().get("Edad"));
            System.out.println("Celular: " + entry.getValue().get("Celular"));
            System.out.println("Teléfono de Emergencia: " + entry.getValue().get("Emergencia"));
            System.out.println("Grupo Sanguíneo: " + entry.getValue().get("Sanguineo"));
            System.out.println();
        }
    }

    private static Integer factura(String categria, Map<String, String> participante) {
            Integer edad =  Integer.parseInt(participante.get("Edad"));
            Integer abono;

            if (categria.equals("A")) {
                if (edad < 18) abono = 1300;
                else abono = 1500;
            } else if (categria.equals("B")) {
                if (edad < 18) abono = 2000;
                else abono = 2300;
            } else {
                abono = 2800;
            }

            return abono;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Map<Integer, Map<String, String>> circuitoChico = new HashMap<>();
        Map<Integer, Map<String, String>> circuitoMediano = new HashMap<>();
        Map<Integer, Map<String, String>> circuitoAvanzado = new HashMap<>();

        Integer opcion = 0;
        int posicionChica = 1;
        int posicionMeidana = 1;
        int posicionAvanzada = 1;
        boolean error;

        mostrarMenu();

        while (opcion != 4 ) {
            opcion = Integer.parseInt(input.next());

            if(opcion == 1) {
                error = false;
                mostrarCategoria();
                String categoria = input.next().toUpperCase();

                Map<String, String> participante = datosParticipante();
                Integer edad =  Integer.parseInt(participante.get("Edad"));

                if (categoria.equals("A")) {
                    circuitoChico.put(posicionChica, participante);
                    posicionChica++;
                }
                else if (categoria.equals("B")) {
                    circuitoMediano.put(posicionMeidana, participante);
                    posicionMeidana++;
                }
                else if (categoria.equals("C") && edad >= 18) {
                    circuitoAvanzado.put(posicionAvanzada, participante);
                    posicionAvanzada++;
                }
                else {
                    error = true;
                    System.out.println("El participante no cumple con los requisitos");
                }

                if(!error)
                    System.out.println("El monto de la inscripción que debe abonar es de $" + factura(categoria, participante));

            } else if (opcion == 2) {
                System.out.print("Indique el número de inscripto a desinscribir: ");
                Integer inscripto = Integer.parseInt(input.next());

                Map<String, String> candidatoBorrado = new HashMap<>();

                if (circuitoChico.containsKey(inscripto))
                    candidatoBorrado = circuitoChico.remove(inscripto);
                else if (circuitoMediano.containsKey(inscripto))
                    candidatoBorrado = circuitoMediano.remove(inscripto);
                else if (circuitoAvanzado.containsKey(inscripto))
                    candidatoBorrado = circuitoAvanzado.remove(inscripto);

                if(candidatoBorrado.isEmpty())
                    System.out.println("No se encontró el participante");
                else
                    System.out.println("El participante " + candidatoBorrado.get("Nombre") + " " + candidatoBorrado.get("Apellido") + " ha sido dado de baja");

            } else if (opcion == 3) {
                System.out.println("Elegir una categoría: A -Chica, B -Medio, C -Avanzado");
                String categoria = input.next().toUpperCase();

                if (categoria.equals("A"))
                    mostrarInscriptos(circuitoChico);
                else if (categoria.equals("B"))
                    mostrarInscriptos(circuitoMediano);
                else
                    mostrarInscriptos(circuitoAvanzado);
            } else {
                break;
            }

            System.out.println();
            mostrarMenu();
        }
    }
}
