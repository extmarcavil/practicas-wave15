package integrador;

import integrador.model.Cliente;
import integrador.repository.ClienteRepository;

import java.util.Scanner;

public class Main {

    private static final ClienteRepository clienteRepository = new ClienteRepository();

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Integer dni=-1;
        Cliente cliente;
        System.out.println("Clientes Actuales del Supermercado");
        System.out.println(clienteRepository.findAll());

        System.out.print("Ingrese DNI a eliminar:");
        dni=Integer.parseInt(scanner.nextLine());

        cliente=clienteRepository.delete(dni);
        if (cliente == null)
            System.out.println("No se encontro un cliente con el DNI indicado");
        else
            System.out.println("Cliente eliminado exitosamente\n" +
                    "Datos del Cliente eliminado:\n"+
                    cliente);

        System.out.println("Clientes Actuales del Supermercado");
        System.out.println(clienteRepository.findAll());

        System.out.print("Ingrese DNI a buscar:");
        dni=Integer.parseInt(scanner.nextLine());

        cliente=clienteRepository.find(dni);
        if (cliente == null)
            System.out.println("No se encontro un cliente con el DNI indicado");
        else
            System.out.println("Cliente encontrado exitosamente\n" +
                    "Datos del Cliente:\n"+
                    cliente);



    }
}
