package JavaP2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise1 {

    static HashMap<String, String> item = new HashMap<>();
    static ArrayList<HashMap<String, String>> listaCircuitoChico = new ArrayList<>();
    static ArrayList<HashMap<String, String>> listaCircuitoMedio = new ArrayList<>();
    static ArrayList<HashMap<String, String>> listaCircuitoAvanzado = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Bienvenido a la carrera de la Selva!");
        menu();
    }

    public static void menu(){
        System.out.println("Menú principal:");
        System.out.println("1. Inscribir a un nuevo participante en una categoría.");
        System.out.println("2. Mostrar los inscritos por categoría.");
        System.out.println("3. Desinscribir a un participante.");
        System.out.println("4. Consultar monto para abonar por participante.");
        System.out.println("Escribe el número de la opción a la que quieres acceder.");

        Scanner teclado = new Scanner(System.in);
        int selectedOption = teclado.nextInt();
        int selectedCircuit = 0;
        switch (selectedOption){
            case 1:
                System.out.println("A que circuito quiere inscribirse?");
                System.out.println("1. Circuito chico");
                System.out.println("2. Circuito medio");
                System.out.println("3. Circuito avanzado");
                selectedCircuit = teclado.nextInt();

                if (selectedCircuit <= 3){
                    System.out.println("Por favor diligencie los siguientes campos:");
                    String dni = teclado.nextLine();
                    System.out.println("DNI:");
                    String nombre = teclado.nextLine();
                    System.out.println("Nombre:");
                    String apellido = teclado.nextLine();
                    System.out.println("Apellido:");
                    String edad = teclado.nextLine();
                    System.out.println("Edad:");
                    String celular = teclado.nextLine();
                    System.out.println("Celular:");
                    String numeroEmergencia = teclado.nextLine();
                    System.out.println("Número de emergencia:");
                    String tipoSangre = teclado.nextLine();
                    System.out.println("Grupo sanguíneo:");
                    item.put("dni",dni);
                    item.put("nombre",nombre);
                    item.put("apellido",apellido);
                    item.put("edad",edad);
                    item.put("celular",celular);
                    item.put("numeroEmergencia",numeroEmergencia);
                    item.put("tipoSangre",tipoSangre);

                    if (selectedCircuit == 1)
                        listaCircuitoChico.add(item);
                    if (selectedCircuit == 2)
                        listaCircuitoMedio.add(item);
                    if (selectedCircuit == 3)
                        listaCircuitoAvanzado.add(item);
                    System.out.println("Se ha inscrito un nuevo participante!");
                    item.clear();
                    menu();
                } else {
                    System.out.println("Ha escogido una opción incorrecta, por favor reinicie la compilación.");
                    menu();
                }
                break;
            case 2:
                System.out.println("Qué circuito quiere consultar?");
                System.out.println("1. Circuito chico");
                System.out.println("2. Circuito medio");
                System.out.println("3. Circuito avanzado");
                selectedCircuit = teclado.nextInt();
                if (selectedCircuit <= 3){
                    if (selectedCircuit == 1)
                        for (HashMap<String, String> inscrito : listaCircuitoChico){
                            for (Map.Entry item: inscrito.entrySet()) {
                                System.out.print(item.getKey() + ": "+ item.getValue() + " - ");
                            }
                            System.out.println();
                        }
                    if (selectedCircuit == 2)
                        listaCircuitoMedio.add(item);
                    if (selectedCircuit == 3)
                        listaCircuitoAvanzado.add(item);
                } else {
                    System.out.println("Ha escogido una opción incorrecta, por favor reinicie la compilación.");
                    menu();
                }
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.println("El valor ingresado es incorrecto, intente de nuevo.");
                menu();
                break;
        }
    }
}
