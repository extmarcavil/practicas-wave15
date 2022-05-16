package com.Bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static private List<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {
	// write your code here
        Cliente c1 = new Cliente("Luciano","Barrera",123456789);
        Cliente c2 = new Cliente("Rodrigo","Garcia",987654321);
        Cliente c3 = new Cliente("Tomas","Olalde",675849321);

        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);

        for (Cliente c:clientes
             ) {
            System.out.println(c);
        }

        clientes.remove(c3);
        System.out.println("----- Despues de remover el c3 -----");
        for (Cliente c:clientes
        ) {
            System.out.println(c);
        }

        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese el DNI del cliente a buscar: ");
        buscarCliente(scan.nextInt());
    }

    private static void buscarCliente(int dni){
        for (Cliente c: clientes
             ) { if (c.getDni() == dni){
            System.out.println(c);
            break;
        }
        }
        System.out.println("El cliente ingresado no existe");
    }
}
