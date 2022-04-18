package ar.com.alehenestroza;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Consola {
    private final static RepositorioFactura repositorioFactura = new RepositorioFactura();
    private final static RepositorioCliente repositorioCliente = new RepositorioCliente();
    private final static Scanner input = new Scanner(System.in);
    private static boolean running = true;

    public static RepositorioFactura getRepositorioFactura() {
        return repositorioFactura;
    }

    public static RepositorioCliente getRepositorioCliente() {
        return repositorioCliente;
    }

    public static Scanner getScanner() {
        return input;
    }

    public static Cliente crearCliente() {
        System.out.println("Ingrese los datos del cliente.");
        System.out.print("Ingrese el nombre: ");
        String nombre = input.nextLine();
        System.out.print("Ingrese el apellido: ");
        String apellido = input.nextLine();
        System.out.print("Ingrese el documento: ");
        String documento = input.nextLine();

        if (!clienteYaExiste(documento)) {
            Cliente nuevoCliente = new Cliente(documento, nombre, apellido);
            repositorioCliente.agregar(nuevoCliente);
            return nuevoCliente;
        } else {
            System.out.println("El cliente ya se encuentra registrado en nuestra base de datos.");
            return null;
        }
    }

    public static boolean clienteYaExiste(String documento) {
        return repositorioCliente.getClientes().containsKey(documento);
    }

    public static Cliente buscarCliente(String documento) {
        Cliente cliente = repositorioCliente.buscarPorDocumento(documento);
        if (cliente == null) {
            System.out.println("No se encontro el cliente en la base de datos. Por favor, registrelo a continuacion.");
            return crearCliente();
        }
        return repositorioCliente.buscarPorDocumento(documento);
    }

    public static Item agregarProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = input.nextLine();
        System.out.print("Ingrese el codigo del producto: ");
        String codigo = input.nextLine();
        System.out.print("Ingrese la cantidad comprada del producto: ");
        int cantidad = input.nextInt();
        input.nextLine();
        System.out.print("Ingrese el precio unitario del producto: ");
        double precioUnitario = input.nextDouble();
        input.nextLine();

        return new Item(nombre, codigo, cantidad, precioUnitario);
    }

    public static Factura crearFactura() {
        System.out.println("Ingrese los datos de la factura.");
        System.out.print("Ingrese el documento del cliente: ");
        String documento = input.nextLine();

        Cliente cliente = buscarCliente(documento);
        Factura factura = new Factura(cliente);

        System.out.println("Ingrese los productos comprados");
        boolean agregando = true;

        while (agregando) {
            factura.addItem(agregarProducto());

            System.out.println("Desea seguir agregando productos? S/N");
            String salir = input.nextLine().toUpperCase(Locale.ROOT);

            agregando = !salir.equals("S");
        }

        repositorioFactura.agregar(factura);
        return factura;
    }

    public static Integer agregarFactura(Factura factura) {
        return repositorioFactura.agregar(factura);
    }

    public static Factura buscarFacturaPorId(Integer id) {
        return repositorioFactura.getFacturas().get(id);
    }

    public static void mostrarClientes() {
        repositorioCliente.mostrarClientes();
    }

    public static void mostrarFacturas() {
        repositorioFactura.mostrarFacturas();
    }

    public static boolean eliminarCliente() {
        System.out.print("Ingrese el documento del cliente: ");
        String documento = input.nextLine();

        Cliente c = repositorioCliente.getClientes().remove(documento);

        return c != null;
    }

    public static void mostrarMenu() {
        System.out.println("--- Supermercado \"El Económico\" ---");
        System.out.println("\n1: Nuevo Cliente\n" +
                "2: Mostrar Clientes\n" +
                "3: Eliminar Cliente\n" +
                "4: Nueva Factura\n" +
                "5: Mostrar Facturas\n" +
                "6: Salir\n");
    }

    public static int getInput() {
        int returnValue = 0;

        try {
            returnValue = input.nextInt();
        } catch (Exception e) {
            System.out.println("Debe ingresar un numero.");
        } finally {
            input.nextLine();
        }

        return returnValue;
    }

    public static boolean isRunning() {
        return running;
    }

    public static void salir() {
        input.close();
        running = false;
    }
}
