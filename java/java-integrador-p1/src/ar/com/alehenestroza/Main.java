package ar.com.alehenestroza;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("12345678", "Alejandro", "Henestroza");
        Cliente cliente2 = new Cliente("45678912", "Laura", "Gomez");
        Cliente cliente3 = new Cliente("78912345", "Martin", "Perez");

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        boolean running = true;
        Scanner input = new Scanner(System.in);
        int option;

        while (running) {
            System.out.println("1: Cargar cliente\n" +
                    "2: Mostrar clientes\n" +
                    "3: Eliminar cliente\n" +
                    "4: Salir\n");
        }

        System.out.print("Ingrese la opcion: ");
        option = input.nextInt();
        input.nextLine();

        switch (option) {
            case 1:
                break;
            case 2:
                for (Cliente c : clientes) {
                    System.out.println(c.toString());
                }
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                break;
        }

        input.close();
    }
}
