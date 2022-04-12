package estructuras_dinamicas;

//Circuito chico: 2 km por selva y arroyos.
//Circuito medio: 5 km por selva, arroyos y barro.
//Circuito Avanzado: 10 km por selva, arroyos, barro y escalada en piedra.
// datos: dni, nombre, apellido, edad, celular, número de emergencia y grupo sanguíneo.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarreraDeLaSelva {
    static List<String> categoriaChico = new ArrayList<>();
    static List<String> categoriaMedio = new ArrayList<>();
    static List<String> categoriaAvanzado = new ArrayList<>();
    static Scanner lector;

    public static void main(String[] args) {
        System.out.println("Bienvenido");
        menu();
    }

    public static void montoA_Abonar(int categoria, int edad) {
        System.out.print("El parcicipante debe abonar: $");
        switch (categoria) {
            case 1:
                if (edad < 18)
                    System.out.println("1300");
                else {
                    System.out.println("1500");
                }
                break;
            case 2:
                if (edad < 18)
                    System.out.println("2000");
                else {
                    System.out.println("2300");
                }
                break;
            case 3:
                System.out.println("2800");
                break;
            default:
                System.out.println("Opción invalida.");
                break;
        }
    }

    public static void desinscribirParticipante() {
        mostrarTodosParticipantes();
        System.out.println("Digita la categoria");
        int categoria = lector.nextInt();
        System.out.println("Digita el numero del participante");
        int indexParticipante = lector.nextInt();
        switch (categoria) {
            case 1:
                categoriaChico.remove(indexParticipante);
                System.out.println("Participante eliminado");
                break;
            case 2:
                categoriaMedio.remove(indexParticipante);
                System.out.println("Participante eliminado");
                break;
            case 3:
                categoriaAvanzado.remove(indexParticipante);
                System.out.println("Participante eliminado");
                break;
            default:
                System.out.println("Opción invalida.");
                break;
        }
    }

    public  static void mostrarTodosParticipantes() {
        System.out.println("1. Cateogria chico");
        for (int i=0; i<categoriaChico.size(); i++)
            System.out.println(i + ". " + categoriaChico.get(i));

        System.out.println("\n2. Categoria medio.");
        for (int i=0; i<categoriaMedio.size(); i++)
            System.out.println(i + ". " + categoriaMedio.get(i));

        System.out.println("\n3. Categoria avanzado.");
        for (int i=0; i<categoriaAvanzado.size(); i++)
            System.out.println(i + ". " +  categoriaAvanzado.get(i));
    }

    public static boolean existeParticipante(String participante) {
        for (String partInscrito : categoriaChico) {
            if (partInscrito.equals(participante))
                return true;
        }
        for (String partInscrito : categoriaMedio) {
            if (partInscrito.equals(participante))
                return true;
        }
        for (String partInscrito : categoriaAvanzado) {
            if (partInscrito.equals(participante))
                return true;
        }
        return false;
    }

    public static void mostrarCategoria(List<String> categoria, String nombreCategoria) {
        System.out.println("Participantes de la categoria " + nombreCategoria);
        for (String participante : categoria) {
            String datosParticipante[] = participante.split(",");
            System.out.println("\n\tDNI: " + datosParticipante[0]);
            System.out.println("\tNombre: " + datosParticipante[1]);
            System.out.println("\tEdad: " + datosParticipante[2]);
            System.out.println("\tTelefono: " + datosParticipante[3]);
            System.out.println("\tTelefono de emergencia: " + datosParticipante[4]);
            System.out.println("\tGrupo sanguineo: " + datosParticipante[5]);
            System.out.println("-------------------------------------------------");
        }
    }

    public static void mostrarInscritos() {
        System.out.println("Selecciona una categoria:");
        System.out.println("1. Categoria chico");
        System.out.println("2. Categoria medio");
        System.out.println("3. Categoria avanxado");
        switch (lector.nextInt()) {
            case 1:
                mostrarCategoria(categoriaChico, "chico");
                break;
            case 2:
                mostrarCategoria(categoriaMedio, "medio");
                break;
            case 3:
                mostrarCategoria(categoriaAvanzado, "avanzado");
                break;
        }
    }

    public static void seleccionCategoria(int categoria, String datosParticipante) {
        switch (categoria) {
            case 1:
                categoriaChico.add(datosParticipante);
                break;
            case 2:
                categoriaMedio.add(datosParticipante);
                break;
            case 3:
                categoriaAvanzado.add(datosParticipante);
                break;
            default:
                System.out.println("Opción invalida.");
                break;
        }
    }

    public static void inscribirParticipante() {
        String datosParticipante = "";
        int edad;
        System.out.println("Digita los datos del participante");
        System.out.println("Digita el DNI");
        datosParticipante += lector.next() + ",";
        System.out.println("Digita el nombre");
        datosParticipante += lector.next() + ",";
        System.out.println("Digita la edad");
        edad = lector.nextInt();
        datosParticipante += edad + ",";
        System.out.println("Digita el celular");
        datosParticipante += lector.next() + ",";
        System.out.println("Digita el numéro de emergencia");
        datosParticipante += lector.next() + ",";
        System.out.println("Digita el grupo sanguineo");
        datosParticipante += lector.next();
        if(existeParticipante(datosParticipante)){
            System.out.println("Este participante ya esta inscrto.");
            return;
        }
        if (edad < 18) {
            System.out.println("Selecciona un circuito:");
            System.out.println("1. Circuito chico. 2 km");
            System.out.println("2. Circuito medio. 5 km");
            int categoria = lector.nextInt();
            seleccionCategoria(categoria, datosParticipante);
            montoA_Abonar(categoria, edad);
        } else {
            System.out.println("Selecciona un circuito:");
            System.out.println("1. Circuito chico. 2 km");
            System.out.println("2. Circuito medio. 5 km");
            System.out.println("3. Circuito medio. 10 km");
            int categoria = lector.nextInt();
            seleccionCategoria(categoria, datosParticipante);
            montoA_Abonar(categoria, edad);
        }
    }

    public static void menu() {
        lector = new Scanner(System.in);
        int seleccion;
        do {
            System.out.println("Menu de opciónes");
            System.out.println("Selecciona una opción");
            System.out.println("0. Salir");
            System.out.println("1. Inscribir a un nuevo participante");
            System.out.println("2. Mostrar a todos participantes inscritos");
            System.out.println("3. Desinscribir a un participante");
            System.out.println("4. Determinar el monto que debe pagar un participante");
            seleccion = lector.nextInt();
            switch (seleccion) {
                case 1:
                    inscribirParticipante();
                    break;
                case 2:
                    mostrarInscritos();
                    break;
                case 3:
                    desinscribirParticipante();
                    break;
                case 0:
                    System.out.println("Adios.");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (seleccion != 0);
        lector.close();
    }
}
