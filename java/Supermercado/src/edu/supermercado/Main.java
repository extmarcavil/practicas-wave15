package edu.supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        Cliente cMauro = new Cliente("423234", "Mauricio", "Perez");
        Cliente cAle = new Cliente("535345", "Alejandra", "Jimenez");
        Cliente cMartha = new Cliente("76747675", "Martha", "Fernandez");

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cMauro);
        clientes.add(cAle);
        clientes.add(cMartha);

        GestionClientes gestionClientes = new GestionClientes(clientes);
        gestionClientes.mostrarClientes();

        System.out.println("Digita el dni de el cliente a borrar:");
        String dni = lector.next();
        Cliente cliente = gestionClientes.buscarCliente(dni);
        if (cliente != null) gestionClientes.eliminarCliente(cliente);
        else System.out.println("Cliente no encontrado");

        System.out.println("Digita el dni de un cliente:");
        dni = lector.next();
        cliente = gestionClientes.buscarCliente(dni);
        if (cliente != null) System.out.println(cliente);
        else System.out.println("Cliente no encontrado");

        lector.close();
    }
}
