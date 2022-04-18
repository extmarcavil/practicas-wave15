package model;

import repositorio.ClienteImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        //clientes
        ClienteImp cliImp = new ClienteImp();

        Cliente cli1 = new Cliente(34567876L, "Francisco", "Giaccaglia");
        Cliente cli2 = new Cliente(20534573L, "Juana", "Rodriguez");
        Cliente cli3 = new Cliente(56576575L, "Leo", "Messi");

        cliImp.save(cli1);
        cliImp.save(cli2);
        cliImp.save(cli3);

        cliImp.mostrarPantalla();

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Ingrese el DNI del cliente buscado");
        Long clienteBuscado = keyboard.nextLong();

        cliImp.buscar(clienteBuscado);


        System.out.println("Ingrese el DNI del cliente que desea borrar");
        Long clienteBorrado = keyboard.nextLong();

        cliImp.eliminar(clienteBorrado);

        //facturas
        //Factura factura = new Factura(456786L, cli1);
    }
}
