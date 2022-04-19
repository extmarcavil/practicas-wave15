import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Pedro", "Alfonso", "123456789");
        Cliente cliente2 = new Cliente("Carla", "Alfonso", "45332455");
        Cliente cliente3 = new Cliente("Matias", "Alfonso", "8654352");

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        mostrarClientes(clientes);

        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el dni del cliente a borrar:");
        String dniABorrar = entrada.next();

        clientes = borrarClientePorDni(clientes, dniABorrar);

        System.out.println();
        System.out.println("Ingrese el dni a buscar:");
        String dniABuscar = entrada.next();

        buscarClientePorDni(clientes, dniABuscar);

    }

    private static void mostrarClientes(List<Cliente> clientes) {
        for(Cliente cliente: clientes) {
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Apellido: " + cliente.getApellido());
            System.out.println("Dni: " + cliente.getDni());
        }
    }

    private static List<Cliente> borrarClientePorDni(List<Cliente> clientes, String dniABorrar) {
        boolean clienteBorrado = false;

        for(Cliente cliente: clientes) {
            if(cliente.getDni().equals(dniABorrar)) {
                clientes.remove(cliente);
                clienteBorrado = true;
                break;
            }
        }
        if(!clienteBorrado)
            System.out.println("No se pudo encontrar al cliente");
        else
            System.out.println("El cliente ha sido borrado con exito");

        return clientes;
    }

    private static void buscarClientePorDni(List<Cliente> clientes, String dniABuscar) {
        boolean dniEncontrado = false;

        for(Cliente cliente: clientes) {
            if(cliente.getDni().equals(dniABuscar)) {
                dniEncontrado = true;
                System.out.println("Cliente encontrado: ");
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("Apellido: " + cliente.getApellido());
                System.out.println("Dni: " + cliente.getDni());
                break;
            }
        }
        if(!dniEncontrado)
            System.out.println("No se encontro un cliente con el dni: " + dniABuscar);
    }
}
