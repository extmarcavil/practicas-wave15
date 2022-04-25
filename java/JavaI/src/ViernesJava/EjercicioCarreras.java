package ViernesJava;

import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioCarreras {
    private static ArrayList<String[]> circuitoChico = new ArrayList<>();
    private static ArrayList<String[]> circuitoMedio = new ArrayList<>();
    private static ArrayList<String[]> circuitoAvanzado = new ArrayList<>();

    private static String[] listaDatos = new String[] {"DNI", "nombre", "apellido", "edad", "celular", "número de emergencia", "grupo sanguíneo"};

    public static void menu(){
        System.out.println("Elija una opción:");
        System.out.println("1- Inscribir participante");
        System.out.println("2- Listar inscriptos a una categoría");
        System.out.println("3- Eliminar participante");
        System.out.println("4- Salir");
    }

    public static ArrayList<String[]> elegirCarrera(){
        System.out.println("Elegir carrera:");
        System.out.println("1- Circuito chico");
        System.out.println("2- Circuito medio");
        System.out.println("3- Circuito avanzado");
        Scanner input = new Scanner(System.in);
        int opc = input.nextInt();
        switch (opc){
            case 1:
                return circuitoChico;
            case 2:
                return circuitoMedio;
            case 3:
                return circuitoAvanzado;
            default:
                return null;
        }
    }

    public static void inscribirParticipante (ArrayList<String[]> carrera){
        String[] corredor = new String[listaDatos.length];
        Scanner entrada = new Scanner(System.in);
        for (int i = 0; i < listaDatos.length; i++){
            System.out.print("Ingrese el " + listaDatos[i] + " del corredor: ");
            corredor[i] = entrada.next();
        }
        int costo = calcularCosto(carrera, corredor);
        if (costo > 0){
            carrera.add(corredor);
            System.out.println("Corredor agregado con costo " + costo);
        } else {
            System.out.println("Inscripción no válida");
        }

    }

    public static int calcularCosto (ArrayList<String[]> carrera, String[] corredor){
        if (carrera == circuitoChico){
            if (Integer.parseInt(corredor[3]) < 18){
                return 1300;
            } else {
                return 1500;
            }
        } else if (carrera == circuitoMedio){
            if (Integer.parseInt(corredor[3]) < 18){
                return 2000;
            } else {
                return 2300;
            }
        } else if (carrera == circuitoAvanzado){
            if (Integer.parseInt(corredor[3]) < 18){
                return -1;
            } else {
                return 2800;
            }
        } else {
            return -1;
        }
    }

    public static void listarParticipantes (ArrayList<String[]> carrera){
        String [] corredor;
        String dato;
        for (int i = 0; i < carrera.size(); i++){
            corredor = carrera.get(i);
            System.out.println("Corredor " + i);
            for (int j = 0; j < corredor.length; j++){
                System.out.println("\t"+listaDatos[j]+":"+corredor[j]);
            }
            System.out.println();
        }
    }

    public static void eliminarParticipante (ArrayList<String[]> carrera){
        Scanner entrada = new Scanner(System.in);
        int eliminado;
        listarParticipantes(carrera);
        System.out.println("Ingrese índice de participante a eliminar:");
        carrera.remove(entrada.nextInt());
    }

    public static void main(String[] args) {
        int opcion;
        Scanner entrada = new Scanner(System.in);
        ArrayList<String[]> carrera;
        menu();
        opcion = entrada.nextInt();
        while (opcion != 4){
            switch (opcion){
                case 1:
                    carrera = elegirCarrera();
                    inscribirParticipante(carrera);
                    break;
                case 2:
                    carrera = elegirCarrera();
                    listarParticipantes(carrera);
                    break;
                case 3:
                    carrera = elegirCarrera();
                    eliminarParticipante(carrera);
                    break;
                default:
                    System.out.println("Comando no reconocido");
            }
            menu();
            opcion = entrada.nextInt();
        }
    }
}
