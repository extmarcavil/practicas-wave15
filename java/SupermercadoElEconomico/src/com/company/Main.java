package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner intro = new Scanner(System.in);
        //Crear Colleccion
        List<Client> listClient = new ArrayList<>();

        //Punto 1, crear 3 clientes
        Client client1 = new Client("123", "Edwin", "Gonzalez");
        Client client2 = new Client("234", "Dario", "Arizmendi");
        Client client3 = new Client("345", "Liliana", "Gonzalez");

        //Punto 2, agregarlos a una coleccion
        listClient.add(client1);
        listClient.add(client2);
        listClient.add(client3);

        //Punto 3, recorrer los cientes de la coleccion
        for (Client c : listClient) {
            System.out.println("dni:" + c.getDni());
            System.out.println("Nombre:" + c.getName());
            System.out.println("Apellido:" + c.getLastName());
        }

        //Punto 4, eliminar un cliente de la coleccion
        System.out.println("Ingrese dni de persona a eliminar");
        String auxDelete = intro.next();
        boolean flagDelete = false;

        for (Client c : listClient) {
            if (c.getDni().equals(auxDelete)) {
                listClient.remove(c);
                flagDelete = true;
                break;
            }
        }
        if (flagDelete == false) {
            System.out.println("No encontro el dni del cliente a borrar");
        } else {
            System.out.println("Cliente eliminado");
        }

        //Punto 5, buscando un cliente por dni
        System.out.println("Ingrese dni de persona a mostrar");
        String auxShow = intro.next();
        boolean flagShow = false;

        for (Client c : listClient) {
            if (c.getDni().equals(auxShow)) {
                System.out.println("dni:" + c.getDni());
                System.out.println("Nombre:" + c.getName());
                System.out.println("Apellido:" + c.getLastName());
                flagShow = true;
                break;
            }
        }
        if (flagShow == false) {
            System.out.println("No encontro el dni del cliente a mostrar");
        } else {
            System.out.println("Cliente mostrado con exito");
        }


    }
}
