import model.Cliente;
import model.Factura;
import model.Item;
import repository.ClienteRepository;
import services.ClienteService;
import services.FacturaService;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final ClienteService clienteService=new ClienteService();
    private static final FacturaService facturaService=new FacturaService();

    static Cliente seleccionarCliente( Scanner scanner){
        Integer dni = -1;
        Cliente cliente=null;
        do {
            System.out.println("Ingrese DNI del cliente");
            dni=Integer.parseInt(scanner.nextLine());
            cliente=clienteService.buscarClientePorDni(dni);
        }while (cliente==null);
        System.out.println(cliente);
        return cliente;
    }

    static void guardarFactura(Factura factura){
        Cliente cliente=clienteService.buscarClientePorDni(factura.getCliente().getDni());
        if (cliente == null) {
            System.out.println("Cliente no existe");
        }else{
            facturaService.crearFactura(factura);
            System.out.println("Factura creada exitosamente");
        }
    }



    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Integer dni=-1;
        Cliente cliente=null;
        Factura factura=null;
        List<Item> items = List.of(
                new Item("1","Pan",1,200.),
                new Item("2","Gaseosa",2,300.),
                new Item("3","Leche",5,150.)
        );

        System.out.println("Clientes Actuales del Supermercado");
        System.out.println(clienteService.listarClientes());
        cliente=seleccionarCliente(scanner);
        factura=new Factura(cliente,items);
        guardarFactura(factura);
        System.out.println(factura);






    }
}
