package com.company;

import com.company.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Creacion de 3 clientes
        Cliente cliente1 = new Cliente("Lionel", "Messi", 12345678L);
        Cliente cliente2 = new Cliente("Cristiano", "Ronaldo", 87654321L);
        Cliente cliente3 = new Cliente("Lionel", "Scaloni", 24681357L);

        //Agregando los clientes a una collection
        List <Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        //Recorriendo la lista de clientes
        System.out.println("------------------");
        System.out.println("Lista de clientes:");
        System.out.println("------------------");
        for (Cliente c : listaClientes){
            System.out.println("Nombre " + c.getNombre() + ", apellido " + c.getApellido() + ", DNI " + c.getDni());
        }

        //Eliminar un cliente
        Scanner teclado = new Scanner(System.in);
        System.out.println("");
        System.out.println("-----------------------------------------------");
        System.out.println("Ingrese el DNI de la persona que quiera borrar");
        System.out.println("-----------------------------------------------");
        Long DNIEliminado = teclado.nextLong();

        //Buscar cliente que se quiere eliminar
        boolean flag = false;
        for (Cliente c : listaClientes){
            if (c.getDni().equals(DNIEliminado)){
                listaClientes.remove(c);
                flag = true;
                break;
            }
        }

        if (!flag){
            System.out.println("No se eliminó a ningun cliente.");
        } else {
            System.out.println("Se eliminó el cliente correctamente.");
        }

        //Buscar una persona por DNI
        flag = false;
        System.out.println("");
        System.out.println("-----------------------------------------------");
        System.out.println("Ingrese el DNI de la persona que quiera buscar");
        System.out.println("-----------------------------------------------");
        Long DNIABuscar = teclado.nextLong();

        for (Cliente c : listaClientes) {
            if (c.getDni().equals(DNIABuscar)){
                System.out.println("La persona con DNI " + c.getDni() + ", se llama " + c.getNombre() + " " + c.getApellido());
                flag = true;
                break;
            }
        }

        if (!flag){
            System.out.println("No se encontró al cliente solicitado.");
        }
    }
}
