package com;

import com.models.Cliente;
import com.models.Factura;
import com.models.Item;
import com.repository.ClienteRepository;
import com.repository.FacturaRepository;
import com.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        List<Item> items = new ArrayList<>();
        List<Factura> facturas = new ArrayList<>();

        double total = 0;


        func(clientes, items,
                facturas, total);

    }

    public static void func(List<Cliente> clientes, List<Item> items, List<Factura> facturas, double total) {
        Scanner in = new Scanner(System.in);
        ClienteRepository clienteRepository = new ClienteRepository();
        ItemRepository itemRepository = new ItemRepository();
        FacturaRepository facturaRepository = new FacturaRepository();

        System.out.println("Bienvenido, elija una opcion");
        System.out.println("-------------------------\n");
        System.out.println("1 - Agregar un cliente");
        System.out.println("2 - Borrar un cliente");
        System.out.println("3 - Mostrar clientes");
        System.out.println("4 - Agregar items");
        System.out.println("5 - Mostrar items");
        System.out.println("6 - Crear factura");
        System.out.println("7 - Mostrar facturas");
        System.out.println("8 - Quit");

        int selection = in.nextInt();
        switch (selection) {
            case 1:
                clientes.add(clienteRepository.registrarElemento());
                volver(clientes, items, facturas, total);
                break;
            case 2:
                clienteRepository.mostrarPantalla(clientes);
                clienteRepository.eliminarElemnto(clientes);
                clienteRepository.mostrarPantalla(clientes);
                volver(clientes, items, facturas, total);
                break;
            case 3:
                clienteRepository.mostrarPantalla(clientes);
                break;
            case 4:
               items.add(itemRepository.registrarElemento());
                volver(clientes, items, facturas, total);
                break;
            case 5:
               itemRepository.mostrarPantalla(items);
                break;
            case 6:
                Cliente c3 = clienteRepository.chequearElemento(clientes);
                if (c3 != null) {
                    for (Item ite : items) {
                        total = total + ite.getCosto();
                    }
                    facturas.add(facturaRepository.registrarFactura(c3, items, total));
                } else {
                    System.out.println("El usuario no existe");
                }
                volver(clientes, items, facturas, total);
                break;
            case 7:
                facturaRepository.mostrarPantalla(facturas);
            case 8:
                return;
            default: return;

        }
    }

    public static void volver(List<Cliente> clientes, List<Item> items, List<Factura> facturas, double total) {
        Scanner in = new Scanner(System.in);
        System.out.println("-------------------------\n");
        System.out.println("1 - Volver al menu");
        System.out.println("2 - Exit");
        int select = in.nextInt();
        if (select == 1) {
            func(clientes, items, facturas, total);
        }else{
            return;
        }

    }
}
