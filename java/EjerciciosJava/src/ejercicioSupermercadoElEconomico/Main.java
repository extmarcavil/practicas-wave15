package ejercicioSupermercadoElEconomico;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Factura> facturas = new ArrayList<>();


    public static void main(String[] args) {

        clientes.add(new Cliente("Elias", "Chaparro", "34343434"));
        clientes.add(new Cliente("Juana", "Pizarro", "34333231"));
        clientes.add(new Cliente("Kevin", "Chuca", "34353637"));
        clientes.forEach(System.out::println);
        System.out.println();

        clientes.remove(1);
        clientes.forEach(System.out::println);

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el DNI a buscar: ");
        String dni = sc.nextLine();
        sc.close();
        try {
            System.out.println(clientes.stream().filter(cliente -> cliente.getDni().equals(dni)).findFirst().get());
        } catch (NoSuchElementException e) {
            System.out.println("Dni de cliente no encontrado");
        }

        Item item1 = new Item("1234", "Salchichas", 2, 150);
        Item item2 = new Item("1254", "Pan de viena", 2, 100);
        Item item3 = new Item("3254", "Mayonesa", 1, 80);

        Factura factura1 = new Factura();

        factura1.addItem(item1);
        factura1.addItem(item2);
        factura1.addItem(item3);
        factura1.addCliente(new Cliente("Jose", "Perez", "23322332"));

        addFactura(factura1);
        System.out.println(factura1.toString());
        clientes.forEach(System.out::println);
    }

    public static void addFactura(Factura factura) {
        if (!clientes.contains(factura.getCliente())) {
            clientes.add(factura.getCliente());
        }
        factura.calcularTotal();
        facturas.add(factura);
    }
}
