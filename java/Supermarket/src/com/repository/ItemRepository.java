package com.repository;

import com.models.Cliente;
import com.models.Item;
import java.util.List;
import java.util.Scanner;

public class ItemRepository implements CRUD<Item>{
    private Scanner in = new Scanner(System.in);
    @Override
    public Item registrarElemento() {
        System.out.println(" ");
        System.out.println("--------------------------------");
        System.out.println("Ingresando item");
        System.out.println(" ");
        System.out.println("Ingrese el nombre");
        String name = in.next();
        System.out.println("Ingrese el codigo");
        int code = in.nextInt();
        System.out.println("Ingrese la cantidad");
        int cant = in.nextInt();
        System.out.println("Ingrese el costo");
        double cost = in.nextInt();
        Item item = new Item(name, code, cant, cost);
        System.out.println("Item agregado");
        System.out.println(" ");
        System.out.println("--------------------------------");
        return item;
    }
    @Override
    public Item chequearElemento(List clientes) {
        return null;
    }

    @Override
    public Item registrarFactura(Cliente elem, List<Item> elem1, double total) {
        return null;
    }


    @Override
    public void mostrarPantalla(List<Item> items) {
        for (Item c1 : items) {
            System.out.println(c1);
        }
    }

    @Override
    public void eliminarElemnto(List<Item> elem) {

        System.out.println("Ingrese el codigo de la factura que desea eliminar");
        try {
            int cod = in.nextInt();
            elem.remove(elem.stream().filter(x -> x.getCodigo() == cod).findAny().orElse(null));
            System.out.println("Se ha eliminado correctamente");
        } catch (Exception e) {
            System.out.println("No ingreso un codigo valido");
        }
    }
}
