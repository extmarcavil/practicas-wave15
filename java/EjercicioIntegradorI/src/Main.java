import CrudRepo.ClienteRepo;
import Supermercado.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ClienteRepo clientes = new ClienteRepo();

        Cliente cl1 = new Cliente("12345", "Jorge", "Perez");
        Cliente cl2 = new Cliente("123456", "Juan", "Rodriguez");
        Cliente cl3 = new Cliente("1234567", "Jose", "Gonzalez");

        clientes.save(cl1);
        clientes.save(cl2);
        clientes.save(cl3);

        clientes.mostrarPantalla();

        clientes.eliminar(cl3.getDni());

        clientes.mostrarPantalla();

        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingresar DNI para buscar cliente: ");
        String busqueda = entrada.next();

        clientes.buscar(busqueda);

        System.out.println("Ejercicio integrador 2");
        System.out.println("-----------------------");

        Item item1 = new Item("Codigo1", "Pan", 3, 30);
        Item item2 = new Item ("Codigo2", "Queso", 2, 60);
        Item item3 = new Item("Codigo3", "Agua", 6, 50);

        List<Item> listaCompras = new ArrayList<>();
        listaCompras.add(item1);
        listaCompras.add(item2);
        listaCompras.add(item3);


        System.out.println("Ingresar DNI para buscar cliente: ");
        busqueda = entrada.next();
        Optional<Cliente> cli = clientes.buscar(busqueda);

        if (cli.isPresent()){
            Factura factura = new Factura(cli.get(), listaCompras);
            System.out.println(factura);
        } else {
            System.out.println("Supermercado.Cliente no encontrado");
        }

    }
}
