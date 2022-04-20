import model.Cliente;
import repository.ClienteImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Pedro", "Alfonso", "123456789");
        Cliente cliente2 = new Cliente("Carla", "Alfonso", "45332455");
        Cliente cliente3 = new Cliente("Matias", "Alfonso", "8654352");

        ClienteImp clienteImplementacion = new ClienteImp();
        clienteImplementacion.guardar(cliente1);
        clienteImplementacion.guardar(cliente2);
        clienteImplementacion.guardar(cliente3);

        clienteImplementacion.mostrarPorPantalla();

        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el dni del cliente a borrar:");
        String dniABorrar = entrada.next();

        clienteImplementacion.eliminar(dniABorrar);

        System.out.println();
        System.out.println("Ingrese el dni a buscar:");
        String dniABuscar = entrada.next();

        clienteImplementacion.buscar(dniABuscar);

    }
}
