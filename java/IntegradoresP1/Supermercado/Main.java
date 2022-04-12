package IntegradoresP1.Supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("38135561", "Wendy", "Sclerandi");
        Cliente cliente2 = new Cliente("38449217", "Alejandro", "Barsotti");
        Cliente cliente3 = new Cliente("38123123", "Rafael", "Sobrero");

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        System.out.println("Listado de clientes: ");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        Scanner input = new Scanner(System.in);
        String dni;
        Cliente clienteEncontrado;

        System.out.println();
        System.out.println("Ingrese el DNI de un cliente para eliminarlo:");
        dni = input.nextLine();
        clienteEncontrado = null;
        for (Cliente cliente : clientes){
            if (cliente.getDni().equals(dni)){
                clienteEncontrado = cliente;
            }
        }
        if (clienteEncontrado != null) {
            System.out.println("Se ha eliminado al cliente " + clienteEncontrado.getNombre());
            clientes.remove(clienteEncontrado);
        } else {
            System.out.println("No se ha encontrado al cliente.");
        }

        System.out.println();
        System.out.println("Ingrese el DNI de un cliente para mostrar sus datos:");
        dni = input.nextLine();
        clienteEncontrado = null;
        for (Cliente cliente : clientes){
            if (cliente.getDni().equals(dni)){
                clienteEncontrado = cliente;
            }
        }
        if (clienteEncontrado != null) {
            System.out.println(clienteEncontrado);
        } else {
            System.out.println("No se ha encontrado al cliente.");
        }

        input.close();
    }
}
