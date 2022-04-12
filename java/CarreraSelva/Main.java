package CarreraSelva;

import java.util.*;

public class Main {
    static ArrayList<LinkedHashMap<String, String>> chico = new ArrayList<>();
    static ArrayList<LinkedHashMap<String, String>> medio = new ArrayList<>();
    static ArrayList<LinkedHashMap<String, String>> avanzado = new ArrayList<>();
    static ArrayList<LinkedHashMap<String, String>> participantes = new ArrayList<>();

    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        int menu = showMenu(input);
        while (menu != 4) {
            switch (menu) {
                case 1: {
                    inscribirParticipante(input);
                    menu = showMenu(input);
                    break;
                }
                case 2: {
                    desinscribirParticipante(input);
                    menu = showMenu(input);
                    break;
                }
                case 3: {
                    mostrarParticipantes(input);
                    menu = showMenu(input);
                    break;
                }
            }
        }
        input.close();
    }

    public static int showMenu(Scanner input) {
        System.out.println("-------------------");
        System.out.println("Seleccione acción:");
        System.out.println("1) Inscribir participante.");
        System.out.println("2) Desinscribir participante.");
        System.out.println("3) Mostrar participantes de una categoría.");
        System.out.println("4) Salir.");
        int menu = Integer.parseInt(input.nextLine());
        return menu;
    }

    public static void inscribirParticipante(Scanner input) {
        LinkedHashMap<String, String> datosParticipante = new LinkedHashMap<>();

        System.out.println("Seleccione categoría de inscripción: ");
        System.out.println("1) Circuito Chico ");
        System.out.println("2) Circuito Medio ");
        System.out.println("3) Circuito Avanzado ");
        int circuito = Integer.parseInt(input.nextLine());
        int id = 0;
        switch (circuito) {
            case 1:
                id = chico.size() + 1;
                break;
            case 2:
                id = medio.size() + 1;
                break;
            case 3:
                id = avanzado.size() + 1;
                break;
        }
        datosParticipante.put("id", Integer.toString(id));

        System.out.println("Ingrese los datos del participante: ");
        System.out.print("DNI: ");
        datosParticipante.put("DNI", input.nextLine());
        System.out.print("Nombre: ");
        datosParticipante.put("Nombre", input.nextLine());
        System.out.print("Apellido: ");
        datosParticipante.put("Apellido", input.nextLine());
        System.out.print("Edad: ");
        String edad = input.nextLine();
        datosParticipante.put("Edad", edad);
        System.out.print("Celular: ");
        datosParticipante.put("Celular", input.nextLine());
        System.out.print("Nro. Emergencia: ");
        datosParticipante.put("Nro. Emergencia", input.nextLine());
        System.out.print("Grupo Sanguineo: ");
        datosParticipante.put("Grupo Sanguineo", input.nextLine());

        if (circuito == 3 && Integer.parseInt(edad) < 18) {
            System.out.println("No se puede inscribir a participantes menores en la categoría avanzada.");
        } else {
            double monto = calcularMonto(circuito, Integer.parseInt(edad));
            datosParticipante.put("Monto", Double.toString(monto));
            System.out.println("--> Monto a Pagar: $" + monto);

            switch (circuito) {
                case 1: {
                    chico.add(datosParticipante);
                    break;
                }
                case 2: {
                    medio.add(datosParticipante);
                    break;
                }
                case 3: {
                    avanzado.add(datosParticipante);
                    break;
                }
            }
            participantes.add(datosParticipante);
        }
    }

    public static double calcularMonto(int circuito, int edad) {
        double monto = 0;
        switch (circuito) {
            case 1: {
                monto = edad < 18 ? 1300 : 1500;
                break;
            }
            case 2: {
                monto = edad < 18 ? 2000 : 2300;
                break;
            }
            case 3: {
                monto = 2800;
                break;
            }
        }
        return monto;
    }

    public static void printDatosParticipante(Map<String, String> participante) {
        System.out.println("ID\t|\tDNI\t|\tNombre\t|\tApellido\t|\tEdad\t|\tCelular\t|\tNro. Emergencia\t|\tGrupo " +
                "Sanquineo\t|\tMonto");
        for (Map.Entry datos : participante.entrySet()) {
            if (datos.getKey() != "Monto") {
                System.out.print(datos.getValue() + "\t");
            } else {
                System.out.println("$" + datos.getValue());
            }
        }
    }


    public static void mostrarParticipantes(Scanner input) {
        System.out.println("Seleccione categoría:");
        System.out.println("1) Circuito Chico ");
        System.out.println("2) Circuito Medio ");
        System.out.println("3) Circuito Avanzado ");
        int circuito = Integer.parseInt(input.nextLine());
        switch (circuito) {
            case 1:
                for (Map persona : chico) {
                    printDatosParticipante(persona);
                }
                break;
            case 2:
                for (Map persona : medio) {
                    printDatosParticipante(persona);
                }
                break;
            case 3:
                for (Map persona : avanzado) {
                    printDatosParticipante(persona);
                }
                break;
        }
    }

    public static void desinscribirParticipante(Scanner input) {
        System.out.print("Ingrese el DNI del participante a desinscribir: ");
        String dni = input.nextLine();
        LinkedHashMap<String, String> eliminar = null;
        for (LinkedHashMap<String, String> persona : participantes) {
            if (Objects.equals(persona.get("DNI"), dni)) {
                eliminar = persona;
                if (chico.contains(persona)) {
                    chico.remove(persona);
                } else if (medio.contains(persona)) {
                    medio.remove(persona);
                } else avanzado.remove(persona);
            }
        }
        if (eliminar == null) {
            System.out.println("La persona no está inscripta.");
        } else {
            System.out.println("Participante eliminado.");
        }
    }
}
