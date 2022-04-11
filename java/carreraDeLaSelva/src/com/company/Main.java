package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // mapa con numero de competidor y y un mapa que contiene los datos del participante
        Map<Integer, Map<String, String>> participantes = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("\n\n\n=======================================\n");
            System.out.println("0 - Inscribir un nuevo participante.");
            System.out.println("1 - Mostrar datos de participantes por categoria.");
            System.out.println("2 - Desinscribir un participante.");
            System.out.println("3 - Exit.");
            System.out.println("=======================================");

            int opcion = scanner.nextInt();

            switch (opcion){
                case 0:
                    inscribirPersona(participantes);
                    break;
                case 1:
                    mostrarDatos(participantes);
                    break;
                case 2:
                    desinscribir(participantes);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Ingrese una opcion valida.");
            }
        }
    }

    public static void inscribirPersona(Map<Integer, Map<String, String>> participantes){
        String nombre;
        String apellido;
        int edad;
        String dni;
        int celular;
        int numeroEmergencia;
        String grupoSanguineo;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre: ");
        nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido: ");
        apellido = scanner.nextLine();
        System.out.println("Ingrese la edad: ");
        edad = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese la cedula: ");
        dni = scanner.nextLine();
        System.out.println("Ingrese el numero celular: ");
        celular = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese un numero de emergencia: ");
        numeroEmergencia = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese el grupo sanguineo: ");
        grupoSanguineo = scanner.nextLine();

        int categoria = elegirCategoria(edad);
        int monto = 0;
        switch(categoria) {
            case 0:
                if(edad < 18){
                    monto = 1300;
                } else {
                    monto = 1500;
                }
                break;
            case 1:
                if(edad < 18){
                    monto = 2000;
                } else {
                    monto = 2300;
                }
                break;
            case 2:
                monto = 2800;
                break;
        }

        Map<String, String> datos = new HashMap<>();
        datos.put("dni", dni);
        datos.put("nombre", nombre);
        datos.put("apellido", apellido);
        datos.put("edad", (String.valueOf(edad)));
        datos.put("celular", (String.valueOf(celular)));
        datos.put("numeroEmergencia", (String.valueOf(numeroEmergencia)));
        datos.put("grupoSanguineo", (grupoSanguineo));
        datos.put("categoria", String.valueOf(categoria));
        datos.put("monto", String.valueOf(monto));
        if(participantes.isEmpty()){
            participantes.put(1,datos);
        } else {
            for (Map.Entry<Integer, Map<String, String>> entry : participantes.entrySet()) {
                Map<String, String> dato = entry.getValue();
                String cedula = dato.get("dni");
                if(cedula.equals(dni)){
                    System.out.println("No se puede inscribir a un participante en mas de un circuito.");
                    return;
                }
            }
            participantes.put(participantes.size() + 1, datos);
        }
        return;
    }

    public static void mostrarDatos(Map<Integer, Map<String, String>> participantes){
        for (Map.Entry<Integer, Map<String, String>> entry : participantes.entrySet()) {
            System.out.println("Numero de participante: " + entry.getKey());
            System.out.println("Informacion del participante: " + entry.getValue() + "\n");
        }
    }

    public static void desinscribir(Map<Integer, Map<String, String>> participantes){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el dni del participante para desinscribir: ");
        String dni = scanner.nextLine();
        for (Map.Entry<Integer, Map<String, String>> entry : participantes.entrySet()) {
            Map<String, String> dato = entry.getValue();
            String cedula = dato.get("dni");
            if(cedula.equals(dni)){
                participantes.remove(entry.getKey());
                System.out.println("El participante se elimino satisfactoriamente.");
                return;
            } else {
                System.out.println("No se logro encontrar el participante solicitado.");
            }
        }
    }

    public static int elegirCategoria(int edad) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int categoria = -1;
        while (flag) {
            System.out.println("Seleccione una de las siguientes categorias: ");
            System.out.println("0 - Circuito chico: 2 km por selva y arroyos.");
            System.out.println("1 - Circuito medio: 5 km por selva, arroyos y barro.");
            System.out.println("2 - Circuito Avanzado: 10 km por selva, arroyos, barro y escalada en piedra.");
            categoria = Integer.parseInt(scanner.nextLine());
            if (categoria >= 0 && categoria <= 2) {
                if(categoria == 2 && edad < 18){
                    System.out.println("El participante debe ser mayor de 18 para inscribirse a esta categoria.");
                    System.out.println("Ingrese una categoria valida.");
                } else{
                    flag = false;
                }
            } else {
                System.out.println("Ingrese una categoria valida.");
            }
        }

        return categoria;
    }
}
