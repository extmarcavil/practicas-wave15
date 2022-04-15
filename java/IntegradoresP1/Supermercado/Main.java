package IntegradoresP1.Supermercado;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Supermercado El Económico");
        System.out.println("-------------------------");

        // Creación de repositorio para guardar los clientes y facturas.
        Repositorio repositorio = new Repositorio();

        // Iniciar scanner.
        Scanner input = new Scanner(System.in);

        // Menu.
        mostrarMenu(input, repositorio);

        input.close();
    }

    private static void mostrarMenu(Scanner input, Repositorio repositorio) {
        System.out.println();
        System.out.println("Seleccione una opción:");
        System.out.println("1) (+) Agregar un cliente." );
        System.out.println("2) (+) Agregar una factura.");
        System.out.println("3) Listar los clientes.");
        System.out.println("4) Listar las facturas.");
        System.out.println("5) Mostrar los datos de un cliente.");
        System.out.println("6) (-) Eliminar un cliente.");
        System.out.println("7) Salir.");

        int opcion = Integer.parseInt(input.nextLine());
        switch (opcion) {
            case 1: {
                repositorio.agregarCliente(input);
                mostrarMenu(input, repositorio);
                break;
            }
            case 2: {
                repositorio.agregarFactura(input);
                mostrarMenu(input, repositorio);
                break;
            }
            case 3: {
                repositorio.mostrarListadoClientes();
                mostrarMenu(input, repositorio);
                break;
            }
            case 4: {
                repositorio.mostrarListadoFacturas();
                mostrarMenu(input, repositorio);
                break;
            }
            case 5: {
                repositorio.mostrarCliente(input);
                mostrarMenu(input, repositorio);
                break;
            }
            case 6: {
                repositorio.eliminarCliente(input);
                mostrarMenu(input, repositorio);
                break;
            }
            default:{
                input.close();
                break;
            }
        }
    }
}
