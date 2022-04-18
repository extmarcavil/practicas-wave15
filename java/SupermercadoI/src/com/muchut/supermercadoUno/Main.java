package com.muchut.supermercadoUno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Cliente cliente1 = new Cliente("Seba", "Muchut", "32074798");
    Cliente cliente2 = new Cliente("Sebas", "Muchut", "33074798");
    Cliente cliente3 = new Cliente("Sebastián", "Muchut", "34074798");

    List<Cliente> ListaClientes = new ArrayList<Cliente>();
    ListaClientes.add(cliente1);
    ListaClientes.add(cliente2);
    ListaClientes.add(cliente3);

    for (Cliente cli: ListaClientes) {
        System.out.println("Nombre: " + cli.getNombre() + "\n" + "Apellido: " + cli.getApellido() + "\n" + "DNI: " + cli.getDni() + "\n" + "----------");
    }
    System.out.println("Cantidad de Clientes: " + ListaClientes.size());
    // elimino un cliente
    ListaClientes.remove(2);
    for (Cliente cli: ListaClientes) {
        System.out.println("Nombre: " + cli.getNombre() + "\n" + "Apellido: " + cli.getApellido() + "\n" + "DNI: " + cli.getDni() + "\n" + "----------");
    }
    System.out.println("Cantidad de Clientes: " + ListaClientes.size());

    Scanner teclado = new Scanner(System.in);
    System.out.println("Ingresar DNI:");
    String dniIngresado = teclado.next();
    if (dniIngresado.length() > 0) {
        for (Cliente cli : ListaClientes) {
            if(cli.getDni().equals(dniIngresado)) {
                System.out.println("Nombre: " + cli.getNombre() + "\n" + "Apellido: " + cli.getApellido() + "\n" + "DNI: " + cli.getDni() + "\n" + "----------");
                return;
            }
        }
        System.out.println("No tenemos Cliente con ese DNI");
    }
    }

}
