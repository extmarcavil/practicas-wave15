package com.company;

import com.company.model.*;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Cliente cli1 = new Cliente("33036945","Matias", "Alvarez");
        Cliente cli2 = new Cliente("53245345","Florencia", "Tuninetti");
        Cliente cli3 = new Cliente("76564535","Daiana", "Alvarez");

        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes.add(cli1);
        listaClientes.add(cli2);
        listaClientes.add(cli3);

        imprimer(listaClientes);

        System.out.println("Ingrese el DNI a eliminar");
        String dniIngresado = " ";

        Scanner teclado = new Scanner(System.in);
        dniIngresado = teclado.next();

        if (!dniIngresado.equals(" ")){
            eliminarCliente(dniIngresado, listaClientes);
        }

        imprimer(listaClientes);

        System.out.println("Ingrese el DNI a buscar...");
        String dniBuscar = teclado.next();

        if (!dniBuscar.equals(" ")){
            buscarDni(dniBuscar, listaClientes);
        }
    }

    private static void buscarDni(String dniBuscar, ArrayList<Cliente> listaClientes) {
        boolean flag = false;
        Cliente clienteEncontrado = null;
        for(Cliente cliente : listaClientes){
            if(cliente.getDni().equals(dniBuscar)){
               flag = true;
               clienteEncontrado = cliente;
               break;
            }
        }
        if (flag){
            System.out.println("Cliente Encontrado! \n" + clienteEncontrado.toString());
        }else{
            System.out.println("Cliente no encontrado");
        }
    }

    private static void eliminarCliente(String dniIngresado, ArrayList<Cliente> listaClientes) {
        Cliente clienteAuxiliar = null;
        for(Cliente cliente : listaClientes){
            if (cliente.getDni().equals(dniIngresado)){
                clienteAuxiliar = cliente;
                break;
            }
        }
        if(clienteAuxiliar != null ) {
            listaClientes.remove(clienteAuxiliar);
        }else{
            System.out.println("Cliente no encontrado para eliminar");
        }
    }

    private static void imprimer(ArrayList<Cliente> listaClientes) {
        for(Cliente cliente : listaClientes){
            System.out.println(cliente.toString());
        }
    }


}
