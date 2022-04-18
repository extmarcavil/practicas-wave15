package ar.com.alehenestroza;

public class Main {

    public static void main(String[] args) {
        while (Consola.isRunning()) {
            Consola.mostrarMenu();
            int option = Consola.getInput();

            switch (option) {
                case 1:
                    Cliente c = Consola.crearCliente();
                    if (c != null) {
                        System.out.println("Cliente creado.\n" + c.toString());
                    }
                    break;
                case 2:
                    Consola.mostrarClientes();
                    break;
                case 3:
                    if (Consola.eliminarCliente()) {
                        System.out.println("Cliente eliminado con exito.");
                    } else {
                        System.out.println("No se encontro el cliente.");
                    }
                    break;
                case 4:
                    Factura f = Consola.crearFactura();
                    if (f != null) {
                        System.out.println("Factura creada.\n" + f.toString());
                    }
                    break;
                case 5:
                    Consola.mostrarFacturas();
                    break;
                case 6:
                    Consola.salir();
                    break;
                default:
                    System.out.println("Por favor, ingrese una opcion valida.\n");
                    break;
            }
        }

    }
}
