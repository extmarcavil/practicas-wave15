package Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Cliente> listado_clientes = new ArrayList<>();
    private static List<Factura> listado_facturas = new ArrayList<>();
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        String input;

        Cliente jose = new Cliente("39201932", "Jose","Marquez");
        listado_clientes.add(jose);
        Cliente ana = new Cliente("22133242", "Ana Laura","Peña");
        listado_clientes.add(ana);
        Cliente maria = new Cliente("45031324", "Maria","Aluar");
        listado_clientes.add(maria);

        listado_clientes.forEach(System.out::println);

        listado_clientes.remove(2);
        System.out.println("-------------------------------------");
        listado_clientes.forEach(System.out::println);
        System.out.println("-------------------------------------");
        System.out.println("Introduzca el DNI del cliente que desea buscar: \n");
        buscarCliente(teclado.nextLine());

        ArrayList<Item> listado_productos = new ArrayList<>();
        listado_productos.add(new Item(3, 2,250,"Queso"));
        listado_productos.add(new Item(6, 1,100,"Azucar"));
        listado_productos.add(new Item(11, 6,4,"Huevo"));

        crearFactura(new Cliente("20324231","Mario", "Bros"),listado_productos);

        

        teclado.close();
    }

    private static void crearFactura(Cliente cliente, ArrayList<Item> productos){
        Factura factura = new Factura(1,cliente,productos);

        if(!listado_clientes.contains(cliente))
            listado_clientes.add(cliente);
        else
            listado_facturas.add(factura);
    }

    private static void buscarCliente(String dni) {
        Cliente cliente = null;

        for (Cliente cli : listado_clientes)
            if (cli.getDni().equals(dni)) {
                cliente = cli;
                break;
            }

        if (cliente != null)
            System.out.println(cliente);
        else
            System.out.println("No se encuentra ningun cliente con el DNI: " + dni + ".");
    }

}
