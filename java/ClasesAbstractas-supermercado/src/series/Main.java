package series;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("123", "Carla", "Sánchez"));
        clientes.add(new Cliente("456", "Ana", "Perez"));
        clientes.add(new Cliente("789", "Juan", "Medina"));

        System.out.println("PRIMERA LISTA DE CLIENTES:::");
        clientes.forEach(System.out::println);

        System.out.println("\nSEGUNDA LISTA DE CLIENTES:::");

        clientes.remove(2);
        clientes.forEach(System.out::println);

        System.out.println("Ingrese DNI a consultar");
        String dni = scanner.nextLine();

        List<Cliente> clienteEncontrado = clientes.stream()
                .filter(cliente -> cliente.dni.compareTo(dni) == 0)
                .collect(Collectors.toList());

        if(clienteEncontrado.size() > 0) System.out.println(clienteEncontrado.get(0));
        else System.out.println("Cliente no encontrado");
    }
}
