package com.company;

import com.company.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Cliente cli1 = new Cliente(12365458L, "Luisina", "de Paula");
        Cliente cli2 = new Cliente(65987456L, "Zlatan", "Ibrahimovic");
        Cliente cli3 = new Cliente(11254789L, "Avril", "Lavigne");

        List<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes.add(cli1);
        listaClientes.add(cli2);
        listaClientes.add(cli3);

        for (Cliente c : listaClientes) {
            System.out.println("Dni: " + c.getDni());
            System.out.println("Nombre: " + c.getNombre());
            System.out.println("Apellido: " + c.getApellido());
        }

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni de la persona a borrar");
        Long dniBorrado = teclado.nextLong();
        boolean bandera = false;

        for (Cliente c : listaClientes) {
            if (c.getDni().equals(dniBorrado)) {
                listaClientes.remove(c);
                bandera = true;
                break;
            }
        }
        if (bandera == false) {
            System.out.println("No se encontró el cliente a borrar");
        }
        else {
            System.out.println("Cliente borrado correctamente");
        }

        System.out.println("Ingrese el dni a buscar");
        Long dniBuscado = teclado.nextLong();

        bandera = false;
        for (Cliente c : listaClientes) {
            if (c.getDni().equals(dniBuscado)) {
                System.out.println("----Cliente encontrado, sus datos son: ----");
                System.out.println("Dni: " + c.getDni());
                System.out.println("Nombre: " + c.getNombre());
                System.out.println("Apellido: " + c.getApellido());
                break;
            }
        }

        if (bandera == false) {
            System.out.println("Cliente no encontrado");
        }

    }
}