package series;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

        Cliente clienteNuevo = clientes.stream().filter(cliente -> cliente.dni == dni).findFirst().orElse(null);
        if(Objects.isNull(clienteNuevo)) clienteNuevo = new Cliente(dni, "N", "N");

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("123", "Pasta", 3, 1.57));
        items.add(new Item("456", "Arroz", 4, 2.00));
        items.add(new Item("678", "Chunky", 5, 2.80));

        Factura factura = new Factura(clienteNuevo, items);
    }
}
