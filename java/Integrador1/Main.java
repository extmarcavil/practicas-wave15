package Integrador1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Integer busquedaDni;
        List<Cliente> clientes = new ArrayList<>();

        Cliente cliente1 = new Cliente(1, "Juan", "Perez");
        Cliente cliente2 = new Cliente(2, "Pablo", "Perez");
        Cliente cliente3 = new Cliente(3, "Pedro", "Perez");

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        System.out.println("Datos de todos los clientes");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }

        System.out.println("Borrando a un cliente");
        clientes.remove(cliente2);

        System.out.print("Escriba un DNI a buscar: ");
        busquedaDni = input.nextInt();

        List<Cliente> clienteBuscado = clientes.stream().filter(cli -> cli.getDni().equals(busquedaDni)).collect(Collectors.toList());

        if (!clienteBuscado.isEmpty())
            System.out.println(clienteBuscado.get(0).toString());
        else
            System.out.println("El número de DNI " + busquedaDni + " no se encontró");


    }
}
