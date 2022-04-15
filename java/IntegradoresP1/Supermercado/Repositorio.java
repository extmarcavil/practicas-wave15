package IntegradoresP1.Supermercado;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Repositorio {
    private List<Cliente> clientes = new LinkedList<>();
    private List<Factura> facturas = new LinkedList<>();

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public Repositorio() {
    }

    public void mostrarListadoClientes(){
        System.out.println("Listado de clientes: ");
        clientes.forEach(System.out::println);
    }

    public void mostrarListadoFacturas(){
        System.out.println("Listado de facturas: ");
        facturas.forEach(System.out::println);
    }

    private void mostrarDatosCliente(Cliente cliente) {
        mostrarDatosCliente(cliente, "");
    }

    private void mostrarDatosCliente(Cliente cliente, String mensaje) {
        if (cliente != null) {
            System.out.println(mensaje + cliente);
        } else {
            System.out.println("(!) No se ha encontrado al cliente.");
        }
    }

    private Cliente buscarClienteDNI(String dni){
        Cliente clienteEncontrado = null;
        for (Cliente cliente : clientes){
            if (cliente.getDni().equals(dni)){
                clienteEncontrado = cliente;
            }
        }
        return clienteEncontrado;
    }

    public Cliente mostrarCliente(Scanner input){
        System.out.println();
        System.out.print("Ingrese el DNI de un cliente para mostrar sus datos: ");
        String dni = input.nextLine();
        Cliente cliente = buscarClienteDNI(dni);
        mostrarDatosCliente(cliente);
        return cliente;
    }

    public void eliminarCliente(Scanner input){
        System.out.println();
        System.out.print("Ingrese el DNI de un cliente para eliminarlo: ");
        String dni = input.nextLine();
        Cliente cliente = buscarClienteDNI(dni);
        if (cliente != null){
            clientes.remove(cliente);
        }
        mostrarDatosCliente(cliente, "(-) Se ha eliminado al cliente ");
    }

    public void agregarCliente(Scanner input) {
        agregarCliente(input, null, true);
    }

    public Cliente agregarCliente(Scanner input, String dni, boolean mostrarMensaje){
        if (dni == null){
            System.out.println();
            System.out.println("Ingrese los datos del cliente:");
            System.out.print("DNI: ");
            dni = input.nextLine();
        }
        System.out.print("Nombre: ");
        String nombre = input.nextLine();
        System.out.print("Apellido: ");
        String apellido = input.nextLine();
        Cliente cliente = new Cliente(dni, nombre, apellido);
        if (!clientes.contains(cliente)){
            clientes.add(cliente);
            if (mostrarMensaje) {
                System.out.println("(+) Cliente agregado exitosamente.");
            }
        } else if (mostrarMensaje) {
            System.out.println("(!) El cliente ya se encuentra registrado.");
        }

        return cliente;
    }

    public void agregarFactura(Scanner input) {
        System.out.println();
        System.out.print("DNI del cliente: ");
        String dni = input.nextLine();
        Cliente cliente = buscarClienteDNI(dni);
        if (cliente == null){
            cliente = agregarCliente(input, dni, false);
        }
        Factura factura = mostrarMenuFactura(input);
        factura.setCliente(cliente);
        factura.calcularTotal(factura);
        facturas.add(factura);
    }

    public Factura mostrarMenuFactura(Scanner input){
        System.out.println("Ingrese los items de la factura:");
        System.out.println("1) (+) Agregar item.");
        System.out.println("2) (-) Eliminar item.");
        System.out.println("3) Listar items.");
        System.out.println("4) Terminar.");
        int opcion = Integer.parseInt(input.nextLine());
        Factura factura = new Factura();
        switch (opcion) {
            case 1:{
                factura.agregarItem(input);
                mostrarMenuFactura(input);
                break;
            }
            case 2:{
                factura.eliminarItem(input);
                mostrarMenuFactura(input);
                break;
            }
            case 3: {
                factura.mostrarItems();
                mostrarMenuFactura(input);
                break;
            }
            default:
                break;
        }
        return factura;
    }
}
