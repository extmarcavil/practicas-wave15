package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Cliente> listaClientes = new ArrayList<>();
        Cliente cliente1 = new Cliente("Gonzalo", "Murias", "37786097");
        listaClientes.add(cliente1);
        Cliente cliente2 = new Cliente("Maria", "Gonzalez", "37859098");
        listaClientes.add(cliente2);
        Cliente cliente3 = new Cliente("Enzo", "Perez", "24852963");
        listaClientes.add(cliente3);

        for (Cliente cliente:listaClientes){
            System.out.println(cliente.toString() + "\n");
        }

        listaClientes.remove(cliente3);

        System.out.println("--Lista de clientes luego de eliminar uno--");
        for (Cliente cliente:listaClientes){
            System.out.println(cliente.toString() + "\n");
        }
        System.out.println("----------");
        System.out.println("Ingrese número de dni del cliente a buscar: ");
        Scanner teclado = new Scanner(System.in);
        String dniBuscar = teclado.nextLine();
        Cliente buscado = new Cliente();

        System.out.println("--El cliente buscado es: --");
        System.out.println(buscado.buscarXDni(dniBuscar, listaClientes).toString());
        //
        List<Item> listaItems = new ArrayList<>();
        Item item1 = new Item("Coca Cola", 100.20, 2);
        Item item2 = new Item("Queso", 300, 1);
        Item item3 = new Item("Pan Lactal", 70.5, 3);
        Item item4 = new Item("Tomate", 50, 5);

        listaItems.add(item1);
        listaItems.add(item2);
        listaItems.add(item3);
        listaItems.add(item4);

        System.out.println("----------");
        System.out.println("Ingrese número de dni del cliente para generar su factura: ");
        String dniBuscar2 = teclado.nextLine();

        Factura factura1 = new Factura();

        if (buscado.buscarXDni(dniBuscar2, listaClientes) == null){
            System.out.println("Cliente no se encuentra registrado, desea registrarlo?");
            char yesNo = teclado.nextLine().charAt(0);

            switch (yesNo){
                case 'Y':
                case 'y':
                    System.out.println("Ingrese nombre del Cliente: ");
                    String nombre = teclado.nextLine();
                    System.out.println("Ingrese apellido del Cliente: ");
                    String apellido = teclado.nextLine();
                    Cliente clienteAlta = new Cliente(nombre, apellido, dniBuscar2);
                    listaClientes.add(clienteAlta);
                    factura1 = new Factura('A', clienteAlta, listaItems);
                    System.out.println("Cliente y Factura generado con éxito");
                break;
                case 'N':
                case 'n': return;
                default:
                    System.out.println("Ingresó una opción errónea. Vuelva a intentarlo");
                break;
            }

        }
        else{
            factura1 = new Factura ('A', buscado.buscarXDni(dniBuscar2, listaClientes), listaItems);
            System.out.println("Factura generada con éxito.");
        }

        List<Factura> listadoFacturas = new ArrayList<>();
        listadoFacturas.add(factura1);

        for (Factura factura : listadoFacturas){
            System.out.println(factura.toString());
        }
        factura1.verDetalle(listaItems);



    }
}


