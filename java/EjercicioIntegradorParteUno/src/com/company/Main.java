package com.company;

import com.company.clases.Cliente;
import com.company.logica.ClienteImplementacion;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println();
        System.out.println("Supermercado “El Económico”");
        System.out.println();

        Cliente c1 = new Cliente("1234567", "Juan", "Perez");
        Cliente c2 = new Cliente("1234321", "Ana", "Gutierrez");
        Cliente c3 = new Cliente("7654123", "Laura", "Fernandez");

//PARTE DOS DEL EJERCICO
        ClienteImplementacion cImpl = new ClienteImplementacion();
        cImpl.save(c1);
        cImpl.save(c2);
        cImpl.save(c3);

        System.out.println("Datos de los clientes: ");
        cImpl.mostrarPantalla();

        System.out.println("Ingrese el dni que desea buscar");
        String dniABuscar = teclado.next();
        cImpl.buscar(dniABuscar);

        System.out.println("Ingrese el dni de la persona que desea borrar");
        String dniABorrar = teclado.next();
        cImpl.eliminar(dniABorrar);
        System.out.println();

        System.out.println("Datos de los clientes: ");
        cImpl.mostrarPantalla();

//PARTE UNO DEL EJERCICIO
        /*List<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes.add(c1);
        listaClientes.add(c2);
        listaClientes.add(c3);*/

         /* for (Cliente c : listaClientes) {
            System.out.println("DNI: " + c.getDni());
            System.out.println("Nombre cliente: " + c.getNombre());
            System.out.println("Apellido cliente: " + c.getApellido());
            System.out.println();
        }*/
      /*  boolean clienteBorrado = false;
        for (Cliente c : listaClientes) {
            if (c.getDni().equals(dniABorrar) && clienteBorrado == false) {
                listaClientes.remove(c);
                clienteBorrado = true;
                System.out.println("El cliente fue borrado correctamente");
                break;
            }
        }
        if (clienteBorrado == false) {
            System.out.println("El cliente no pudo ser borrado");
        }*/

       /* System.out.println("Ingrese el dni que desea buscar");
        String dniABuscar = teclado.next();
       boolean clienteEncontrado = false;
        for (Cliente c : listaClientes) {
            if (c.getDni().equals(dniABuscar)) {
                System.out.println("------ Datos del usuario ------");
                System.out.println("DNI: " + c.getDni());
                System.out.println("Nombre cliente: " + c.getNombre());
                System.out.println("Apellido cliente: " + c.getApellido());
                break;
            }
        }
        if (clienteEncontrado == false) {
            System.out.println("El cliente no fue encontrado");
        }*/
    }
}
