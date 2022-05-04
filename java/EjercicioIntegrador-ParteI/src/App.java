import model.Cliente;
import model.Factura;
import model.Item;
import repository.ClienteRepository;
import repository.FacturaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class App {
    static FacturaRepository facturaRepository = new FacturaRepository();
    static ClienteRepository clienteRepository = new ClienteRepository();
    public static void main(String[] args) {
        Cliente c1 = new Cliente("11111111", "Tomas", "Ravelli");
        clienteRepository.save(c1);
        Cliente c2 = new Cliente("22222222", "Ramon", "Juarez");
        clienteRepository.save(c2);
        Cliente c3 = new Cliente("33333333", "Juan", "Perez");
        clienteRepository.save(c3);
        
        clienteRepository.findAll().forEach(System.out::println);
        clienteRepository.deleteByIndex(2);
        clienteRepository.findAll().forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);
        String dni = solicitarDNI(scanner);

        Optional<Cliente> clienteOptional = findClienteByDNI(dni);
        if(clienteOptional.isPresent()){
            System.out.println(clienteOptional.get());
        } else {
            System.out.println("No existe cliente con DNI: " + dni);
        }

        Cliente clienteFactura = new Cliente("111111110", "Tomas", "Ravelli");
        clienteOptional= findClienteByDNI(clienteFactura.getDni());
        if(clienteOptional.isEmpty()){
            clienteRepository.save(clienteFactura);
        }
        List<Item> compra = List.of(crearItem(1,"Banana", 3, 20d),
                                    crearItem(2, "Pera", 4, 35.5),
                                    crearItem(3, "Manzana", 4, 50d));
        facturaRepository.save(crearFactura(clienteFactura, compra));
        System.out.println(facturaRepository.findAll());
        System.out.println(clienteRepository.findAll());
    }

    public static String solicitarDNI(Scanner scanner){
        System.out.println("Ingrese el DNI del cliente que desea buscar: ");
        return scanner.nextLine();
    }
    public static Optional<Cliente> findClienteByDNI(String dni){
        return clienteRepository.findAll().stream().filter(cliente1 -> cliente1.getDni().equals(dni)).findFirst();
    }
    public static Item crearItem(Integer codigo, String nombre, Integer cantidad, Double costo){
        return new Item( codigo, nombre, cantidad, costo);
    }
    public static Factura crearFactura(Cliente c, List<Item> compra){
        return new Factura(c, compra, calcularCosto(compra));
    }
    public static Double calcularCosto(List<Item> compra){
        return compra.stream().mapToDouble(i -> i.getCantidadComprada()*i.getCostoUnitario()).sum();
    }
}
