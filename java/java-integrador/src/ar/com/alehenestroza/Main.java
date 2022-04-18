package ar.com.alehenestroza;

public class Main {

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            Consola.mostrarMenu();
            int option = Consola.getInput();

            switch (option) {
                case 1:
                    Cliente c = Consola.buscarCliente(Consola.agregarCliente());
                    System.out.println("Cliente creado.\n" + c.toString());
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
                    break;
                case 5:
                    break;
                case 6:
                    running = false;
                    Consola.salir();
                    break;
                default:
                    break;
            }
        }

    }
}
