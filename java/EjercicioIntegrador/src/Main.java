import models.Cliente;
import models.Factura;
import models.Item;

import java.util.Scanner;

public class Main {
    private static final Supermercado supermercado = new Supermercado();

    public static void main(String[] args) {
        addClientes();

        supermercado.imprimirClientes();
        supermercado.removeClientePorDni("124");
        supermercado.imprimirClientes();

        System.out.println("Buscar cliente por dni:");

        try (Scanner scanner = new Scanner(System.in)) {
            supermercado.imprimirClientePorDni(String.valueOf(scanner.nextInt()));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ups, algo salio mal...");
        }

        addFactura();

        System.out.println("");
        System.out.println("FACTURA AGREGADA");
        System.out.println("");

        supermercado.imprimirClientes();
        supermercado.imprimirFacturas();
    }

    private static void addFactura() {
        Factura f = new Factura();
        f.setCliente(supermercado.findClienteByDni("123").get());
        Item i1 = new Item();
        i1.setNombre("Comida de perros");
        i1.setCodigo("111");
        i1.setCantidadComprada(2);
        i1.setPrecioUnitario(25);
        Item i2 = new Item();
        i2.setNombre("Plutonio en barras");
        i2.setCodigo("112");
        i2.setCantidadComprada(1);
        i2.setPrecioUnitario(90000);
        f.addItem(i1);
        f.addItem(i2);
        supermercado.addFactura(f);
    }

    private static void addClientes() {
        Cliente c1 = new Cliente();
        c1.setId(1L);
        c1.setDni("123");
        c1.setNombre("Cosme");
        c1.setApellido("Fulanito");

        Cliente c2 = new Cliente();
        c2.setId(2L);
        c2.setDni("124");
        c2.setNombre("Max");
        c2.setApellido("Power");

        Cliente c3 = new Cliente();
        c3.setId(3L);
        c3.setDni("125");
        c3.setNombre("Homero");
        c3.setApellido("Thompson");

        supermercado.addCliente(c1);
        supermercado.addCliente(c2);
        supermercado.addCliente(c3);
    }
}
