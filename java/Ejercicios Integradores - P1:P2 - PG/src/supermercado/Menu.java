package supermercado;

import supermercado.model.Cliente;
import supermercado.model.Factura;
import supermercado.model.Producto;
import supermercado.repository.ClienteImp;
import supermercado.repository.FacturaImp;

import java.util.*;

public class Menu {

    public void agregarClientePorDefecto(ClienteImp clienteImp){
        Scanner scanner = new Scanner(System.in);
        //Clientes por defecto
        clienteImp.guardar(new Cliente("3232323", "Pedro", "Perez"));
        clienteImp.guardar(new Cliente("4343434", "Dario", "Dominguez"));
        clienteImp.guardar(new Cliente("5656566", "Fernando", "Fernandez"));
        mostrarClientes(clienteImp);
        presionaTecla(scanner);
    }

    public void mostrarClientes(ClienteImp clienteImp){
        clienteImp.mostrarPantalla();
        Scanner scanner = new Scanner(System.in);
        presionaTecla(scanner);
    }

    public void presionaTecla(Scanner scanner){
        System.out.println("\nPresione una tecla para continuar.\n");
        scanner.nextLine();
    }

    public void eliminarCliente(ClienteImp clienteImp){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngrese la cedula del cliente a borrar: \n");
        String dni = scanner.nextLine();
        clienteImp.eliminar(dni);
        presionaTecla(scanner);
    }

    public void mostrarClientePorDni(ClienteImp clienteImp){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngrese la cedula del cliente a buscar: \n");
        String dni = scanner.nextLine();
        Optional<Cliente> cliente = clienteImp.buscar(dni);
        if (cliente.isPresent()) {
            System.out.println(cliente);
        } else {
            System.out.println("El cliente ingresado no fue encontrado!");
        }
        presionaTecla(scanner);
    }

    public void agregarClienteNuevo(ClienteImp clienteImp){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngrese la cedula: ");
        String dni = scanner.nextLine();
        System.out.println("\nIngrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("\nIngrese el apellido: ");
        String apellido = scanner.nextLine();
        clienteImp.guardar(new Cliente(dni, nombre, apellido));
        presionaTecla(scanner);
    }

    public void crearFactura(ClienteImp clienteImp, FacturaImp facturaImp){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngrese la cedula del cliente a ingresar en la factura: \n");
        String dni = scanner.nextLine();
        Optional<Cliente> cliente = clienteImp.buscar(dni);
        if(cliente.isEmpty()) {
            System.out.println("\nCrear nuevo cliente");
            agregarClienteNuevo(clienteImp);
            cliente = clienteImp.buscar(dni);
        }
        //Lista de productos agregados por defecto a la factura
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1,"Mayonesa", 1, 10));
        productos.add(new Producto(2,"Pan", 1, 10));
        productos.add(new Producto(3,"Jamon", 1, 10));
        productos.add(new Producto(4,"Queso", 2, 10));

        facturaImp.guardar(new Factura(String.valueOf(Math.random()), cliente.get(), productos, calcularTotal(productos)));
        System.out.println("\nLa factura fue creada para el cliente: " + cliente.get().getNombre());
        presionaTecla(scanner);
    }

    public void mostrarFacturas(FacturaImp facturaImp){
        facturaImp.mostrarPantalla();
        Scanner scanner = new Scanner(System.in);
        presionaTecla(scanner);
    }

    public void mostrarFacturaPorId(FacturaImp facturaImp){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngrese el id de la factura a buscar: \n");
        String dni = scanner.nextLine();
        Optional<Factura> factura = facturaImp.buscar(dni);
        if (factura.isPresent()) {
            System.out.println(factura);
        } else {
            System.out.println("La factura ingresada no fue encontrada!");
        }
        presionaTecla(scanner);
    }

    public void eliminarFactura(FacturaImp facturaImp){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngrese el id de la factura a borrar: \n");
        String dni = scanner.nextLine();
        facturaImp.eliminar(dni);
        presionaTecla(scanner);
    }

    private double calcularTotal(List<Producto> productos){
        return productos.stream().mapToDouble(p -> p.getCosto()*p.getCantidadComprada()).sum();
    }
}
