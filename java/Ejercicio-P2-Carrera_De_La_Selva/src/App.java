import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    static Map<Integer, String> circuitoChico = new HashMap<>();
    static Map<Integer, String> circuitoMedio = new HashMap<>();
    static Map<Integer, String> circuitoGrande = new HashMap<>();
    public static void main(String[] args) {

        int opt = -1;
        Scanner scanner = new Scanner(System.in);

        while(opt != 4){
            System.out.println("Ingrese una opcion: \n" +
                    "Opciones: \n" +
                    "1 - Nuevo participante\n" +
                    "2 - Ver participantes\n" +
                    "3 - Quitar participante\n" +
                    "4 - Salir\n");

            opt = Integer.parseInt(scanner.nextLine());
            switch (opt) {
                case 1:{
                    agregarPersona(scanner);
                    break;
                }
                case 2: {
                    imprimirParticipantes(scanner);
                    break;
                }
                case 3: {
                    quitarParticipante(scanner);
                    break;
                }
            }

        }
    }

    private static void agregarPersona(Scanner scanner){
        String persona, dni;
        System.out.println("Ingrese datos del corredor: ");
        System.out.println("DNI: ");
        dni = scanner.nextLine();
        persona = "DNI: " + dni;
        System.out.println("Nombre y apellido: ");
        persona += ", NOMBRE Y APELLIDO: " + scanner.nextLine();
        System.out.println("Edad: ");
        int edad = Integer.parseInt(scanner.nextLine());
        persona += ", EDAD: " + edad;
        System.out.println("CELULAR : ");
        persona += ", CELULAR: " + scanner.nextLine();
        System.out.println("NUMERO DE EMERGENCIA: ");
        persona += ", NRO DE EMERGENCIA: " + scanner.nextLine();
        System.out.println("GRUPO SANGUINEO: ");
        persona += ", GRUPO SANGUINEO: " + scanner.nextLine();


        System.out.println("¿A que circuito desea agregar el participante? Seleecione opcion:\n" +
                "1 - Circuito chico\n" +
                "2 - Circuito medio\n" +
                "3 - Circuito grande\n");

        int circuitoSeleccionado = Integer.parseInt(scanner.nextLine());
        boolean prohibido = false;
        switch (circuitoSeleccionado) {
            case 1: {
                for (String s: circuitoChico.values()) {
                    if(s.contains("DNI: " + dni)){
                        prohibido = true;
                        break;
                    }
                }
                for (String s: circuitoMedio.values()) {
                    if(s.contains("DNI: " + dni)){
                        prohibido = true;
                        break;
                    }
                }
                for (String s: circuitoGrande.values()) {
                    if(s.contains("DNI: " + dni)){
                        prohibido = true;
                        break;
                    }
                }
                if(!prohibido) {
                    if (edad > 18) {
                        persona += ", INSCRIPCION: $1500";
                    } else {
                        persona += ", INSCRIPCION: $1300";
                    }
                    if(circuitoChico.isEmpty()){
                        circuitoChico.put(1, persona);
                    } else {
                        circuitoChico.put(circuitoChico.keySet().size() + 1, persona);
                    }
                } else {
                    System.out.println("Prohibido! El participante ya esta inscripto en alguno de los circuitos");
                }
                break;
            }
            case 2: {
                for (String s: circuitoChico.values()) {
                    if(s.contains("DNI: " + dni)){
                        prohibido = true;
                        break;
                    }
                }
                for (String s: circuitoMedio.values()) {
                    if(s.contains("DNI: " + dni)){
                        prohibido = true;
                        break;
                    }
                }
                for (String s: circuitoGrande.values()) {
                    if(s.contains("DNI: " + dni)){
                        prohibido = true;
                        break;
                    }
                }
                if(!prohibido) {
                    if (edad > 18) {
                        persona += ", INSCRIPCION: $2300";
                    } else {
                        persona += ", INSCRIPCION: $2000";
                    }
                    if(circuitoMedio.isEmpty()){
                        circuitoMedio.put(1, persona);
                    } else {
                        circuitoMedio.put(circuitoMedio.keySet().size() + 1, persona);
                    }
                } else {
                    System.out.println("Prohibido! El participante ya esta inscripto en algunos de los circuitos");
                }
                break;
            }
            case 3: {
                if (edad > 18) {
                    for (String s: circuitoChico.values()) {
                        if(s.contains("DNI: " + dni)){
                            prohibido = true;
                            break;
                        }
                    }
                    for (String s: circuitoMedio.values()) {
                        if(s.contains("DNI: " + dni)){
                            prohibido = true;
                            break;
                        }
                    }
                    for (String s: circuitoGrande.values()) {
                        if(s.contains("DNI: " + dni)){
                            prohibido = true;
                            break;
                        }
                    }
                    if(!prohibido) {
                        persona += ", INSCRIPCION: $2800";
                        if(circuitoGrande.isEmpty()){
                            circuitoGrande.put(1, persona);
                        } else {
                            circuitoGrande.put(circuitoGrande.keySet().size() + 1, persona);
                        }
                    }
                    else {
                        System.out.println("Prohibido! El participante ya esta inscripto en algunos de los circuitos");
                    }
                } else {
                    System.out.println("No se permiten menores de 18 años");
                }
                break;
            }
        }
    }
    private static void imprimirParticipantes(Scanner scanner){
        System.out.println("¿Participantes de que circuito? Seleecione opcion:\n" +
                "1 - Circuito chico\n" +
                "2 - Circuito medio\n" +
                "3 - Circuito grande\n");

        int circuitoSeleccionado = Integer.parseInt(scanner.nextLine());
        switch (circuitoSeleccionado) {
            case 1: {
                for(Map.Entry<Integer, String> m: circuitoChico.entrySet()) {
                    System.out.println("Numero inscripcion: " + m.getKey() + " --- Pariticipante: " + m.getValue());
                }
                break;
            }
            case 2: {
                for(Map.Entry<Integer, String> m: circuitoMedio.entrySet()){
                    System.out.println("Numero inscripcion: " + m.getKey() + " --- Pariticipante: " + m.getValue());
                }
                break;
            }
            case 3: {
                for(Map.Entry<Integer, String> m: circuitoGrande.entrySet()){
                    System.out.println("Numero inscripcion: " + m.getKey() + " --- Pariticipante: " + m.getValue());
                }
            }
        }

    }
    private static void quitarParticipante(Scanner scanner) {
        System.out.println("Ingrese numero de inscripcion del participante: ");
        int nroInscripcion = Integer.parseInt(scanner.nextLine());
        System.out.println("¿De que circuito desea quitar el participante? Seleecione opcion:\n" +
                "1 - Circuito chico\n" +
                "2 - Circuito medio\n" +
                "3 - Circuito grande\n");
        int circuitoSeleccionado = Integer.parseInt(scanner.nextLine());
        switch (circuitoSeleccionado) {
            case 1: {
                circuitoChico.remove(nroInscripcion);
                break;
            }
            case 2: {
                circuitoMedio.remove(nroInscripcion);
                break;
            }
            case 3: {
                circuitoGrande.remove(nroInscripcion);
                break;
            }
        }
    }
}
