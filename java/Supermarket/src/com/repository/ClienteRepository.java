package com.repository;

import com.models.Cliente;
import java.util.List;
import java.util.Scanner;

public class ClienteRepository implements CRUD<Cliente> {

    private Scanner in = new Scanner(System.in);

    @Override
    public Cliente registrarElemento() {
        try {
            System.out.println("Agregando cliente...");
            System.out.println("");
            System.out.println("Ingrese el nombre");
            String name = in.next();
            System.out.println("Ingrese el apellido");
            String lastName = in.next();
            System.out.println("Ingrese el dni");
            int dni = in.nextInt();
            Cliente cliente = new Cliente(name, lastName, dni);
            System.out.println("Cliente agregado");
            return cliente;
        }catch (Exception e){
            System.out.println("Debe agregar un campo valido");

        }
        return null;
    }

    @Override
    public Cliente chequearElemento(List<Cliente> clientes) {
        System.out.println("Ingrese el dni del cliente");
        try {
            int dni = in.nextInt();
            Cliente c = clientes.stream().filter(x -> x.getDni() == dni).findAny().orElse(null);
            return  c;
        } catch (Exception e) {
            System.out.println("No ingreso un dni valido");
            return null;
        }
    }


    @Override
    public Cliente registrarFactura(Cliente elem, List<Cliente> elem1, double total) {
        return null;
    }

    @Override
    public void mostrarPantalla(List<Cliente> clientes) {
        for (Cliente c1 : clientes) {
            System.out.println(c1);
        }
    }

    @Override
    public void eliminarElemnto(List<Cliente> elem) {

        System.out.println("Ingrese el dni del cliente que desea eliminar");
        try {
            int dni = in.nextInt();
            elem.remove(elem.stream().filter(x -> x.getDni() == dni).findAny().orElse(null));
            System.out.println("Se ha eliminado correctamente");
        } catch (Exception e) {
            System.out.println("No ingreso un dni valido");
        }
    }
}
