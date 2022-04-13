package supermercado;

import supermercado.repository.ClienteImp;
import supermercado.repository.FacturaImp;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ClienteImp clienteImp = new ClienteImp();
        FacturaImp facturaImp = new FacturaImp();
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("\n=============BIENVENIDOS===============\n");
            System.out.println("0 - Agregar clientes por defecto.");
            System.out.println("1 - Agregar un nuevo cliente.");
            System.out.println("2 - Mostrar un cliente por dni.");
            System.out.println("3 - Eliminar un cliente.");
            System.out.println("4 - Mostrar listado de clientes.");
            System.out.println("5 - Agregar factura.");
            System.out.println("6 - Mostrar todas las facturas.");
            System.out.println("7 - Mostrar una factura por id.");
            System.out.println("8 - Eliminar una factura.");
            System.out.println("9 - Exit.");
            System.out.println("=======================================");

            int opcion = scanner.nextInt();

            switch (opcion){
                case 0:
                    menu.agregarClientePorDefecto(clienteImp);
                    break;
                case 1:
                    menu.agregarClienteNuevo(clienteImp);
                    break;
                case 2:
                    menu.mostrarClientePorDni(clienteImp);
                    break;
                case 3:
                    menu.eliminarCliente(clienteImp);
                    break;
                case 4:
                    menu.mostrarClientes(clienteImp);
                    break;
                case 5:
                    menu.crearFactura(clienteImp, facturaImp);
                    break;
                case 6:
                    menu.mostrarFacturas(facturaImp);
                    break;
                case 7:
                    menu.mostrarFacturaPorId(facturaImp);
                    break;
                case 8:
                    menu.eliminarFactura(facturaImp);
                    break;
                case 9:
                    System.out.println("Gracias por utilizar el programa! \n");
                    return;
                default:
                    System.out.println("Ingrese una opción valida.");
            }
        }
    }
}
