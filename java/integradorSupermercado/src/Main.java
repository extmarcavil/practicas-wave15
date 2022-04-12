import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static private List<Cliente> listaClientes = new ArrayList<>();
    static private List<Factura> listaFacturas = new ArrayList<>();

    public static void main(String[] args) {
        listaClientes.add(new Cliente("Esteban", "Quito", "12345678"));
        listaClientes.add(new Cliente("Moria", "Casan", "234768"));
        listaClientes.add(new Cliente("Mirta", "Legrand", "1"));

        System.out.println(listaClientes);
        listaClientes.remove(1);
        System.out.println(listaClientes);

        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese el DNI del cliente a buscar: ");
        buscarCliente(scan.next());

        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "leche", 3, 98));
        items.add(new Item(2, "fideos", 5, 22));
        items.add(new Item(3, "arroz", 1, 35));

        guardarFactura(new Cliente("Jose", "fernandez", "64537"), items);
    }

    private static void guardarFactura(Cliente cliente, List<Item> items) {
        Factura factura = new Factura(cliente, items);

        if(!listaClientes.contains(cliente))
            listaClientes.add(cliente);

        listaFacturas.add(factura);
    }

    private static void buscarCliente(String dni) {
        Cliente encontrado = null;

        for (Cliente c : listaClientes)
            if(c.getDni().equals(dni)) {
                encontrado = c;
                break;
            }

        if(encontrado != null)
            System.out.println(encontrado);
        else
            System.out.println("No hay ningun cliente con DNI " + dni);
    }
}
