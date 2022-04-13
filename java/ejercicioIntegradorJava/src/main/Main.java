package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Cliente> listaClientes = new ArrayList<>();
        Cliente cliente1 = new Cliente("Gonzalo", "Murias", "37786097");
        listaClientes.add(cliente1);
        Cliente cliente2 = new Cliente("Maria", "Gonzalez", "37859098");
        listaClientes.add(cliente2);
        Cliente cliente3 = new Cliente("Enzo", "Perez", "24852963");
        listaClientes.add(cliente3);

        for (Cliente cliente:listaClientes){
            System.out.println(cliente.toString() + "\n");
        }

        listaClientes.remove(cliente3);

        System.out.println("--Lista de clientes luego de eliminar uno--");
        for (Cliente cliente:listaClientes){
            System.out.println(cliente.toString() + "\n");
        }

        System.out.println("Ingrese número de dni del cliente: ");
        Scanner teclado = new Scanner(System.in);
        String dniBorrar = teclado.nextLine();


        listaClientes.remove(teclado);

        System.out.println("--Lista de clientes luego de eliminar uno--");
        if (!listaClientes.removeIf(cliente -> cliente.getDni().equals(dniBorrar))) {
            System.out.println("El cliente ingresado no se encuentra.");
        }
        else{
            for (Cliente cliente:listaClientes){
                System.out.println(cliente.toString() + "\n");
            }
        }


    }
}


