package com.company;

import com.company.model.Client;
import com.company.model.Item;
import com.company.model.Resume;
import com.company.repository.ClientImp;

import java.util.*;

public class Main {

    public static void main(String[] args) {


        Scanner intro = new Scanner(System.in);

        //Implementacion
        ClientImp clientImp = new ClientImp();

        //Crear Colleccion
        List<Client> listClient = new ArrayList<>();
        List<Resume> listResume = new ArrayList<>();
        List<Item> listItem = new ArrayList<>();

        //Punto 1, crear 3 clientes
        Client client1 = new Client("123", "Edwin", "Gonzalez");
        Client client2 = new Client("234", "Dario", "Arizmendi");
        Client client3 = new Client("345", "Liliana", "Gonzalez");


        //Punto 2, agregarlos a una coleccion
        //listClient.add(client1);
        //listClient.add(client2);
        //listClient.add(client3);


        //Guardandolos en la implementacion Cliente
        clientImp.save(client1);
        clientImp.save(client2);
        clientImp.save(client3);

        //Punto 3, recorrer los cientes de la coleccion
        /*for (Client c : listClient) {
            System.out.println("dni:" + c.getDni());
            System.out.println("Nombre:" + c.getName());
            System.out.println("Apellido:" + c.getLastName());
        }**/

        //Mostrando todos los clientes
        clientImp.showScreen();

        //Punto 4, eliminar un cliente de la coleccion
        System.out.println("Ingrese dni de persona a eliminar");
        String auxDelete = intro.next();
        boolean flagDelete = false;

        /*for (Client c : listClient) {
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
        }**/

        clientImp.delete(auxDelete);


        //Punto 5, buscando un cliente por dni
        System.out.println("Ingrese dni de persona a mostrar");
        String auxShow = intro.next();
        boolean flagShow = false;

        /*for (Client c : listClient) {
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
        }**/
        clientImp.search(auxShow);

        //Crear nueva factura
        if(listClient.contains(client1)){
            System.out.print("ya esta");
        }else{
            listClient.add(client1);
        }

        Item milk = new Item();
        listItem.add(milk);
        Resume invoice = new Resume(client1, listItem);



    }
}
