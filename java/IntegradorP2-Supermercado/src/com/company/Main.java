package com.company;

import com.company.model.Cliente;
import repository.ClienteImp;
import repository.FacturaImp;
import repository.ItempImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ClienteImp ClienteImp = new ClienteImp();
        FacturaImp facturaImp = new FacturaImp();
        ItempImp itempImp = new ItempImp();

        //Creacion de 3 clientes
        Cliente cliente1 = new Cliente("Lionel", "Messi", 12345678L);
        Cliente cliente2 = new Cliente("Cristiano", "Ronaldo", 87654321L);
        Cliente cliente3 = new Cliente("Lionel", "Scaloni", 24681357L);

        ClienteImp.save(cliente1); //Guardar un cliente
        ClienteImp.mostrarPantalla(); //Mostrar todos los clientes

        //Buscar una persona por DNI
        Scanner teclado = new Scanner(System.in);
        System.out.println("");
        System.out.println("-----------------------------------------------");
        System.out.println("Ingrese el DNI de la persona que quiera buscar");
        System.out.println("-----------------------------------------------");
        Long DNIABuscar = teclado.nextLong();
        ClienteImp.buscar(DNIABuscar);

        //Eliminar un cliente
        System.out.println("");
        System.out.println("-----------------------------------------------");
        System.out.println("Ingrese el DNI de la persona que quiera borrar");
        System.out.println("-----------------------------------------------");
        Long DNIEliminado = teclado.nextLong();
        ClienteImp.eliminar(DNIEliminado);
    }
}
