import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Esteban", "Quito", "12345678");
        Cliente cliente2 = new Cliente("Moria", "Casan", "234768");
        Cliente cliente3 = new Cliente("Mirta", "Legrand", "1");

        List<Cliente> listaClientes = new ArrayList<>();

        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        System.out.println(listaClientes);
        listaClientes.remove(cliente2);
        System.out.println(listaClientes);

        Scanner scan = new Scanner(System.in);

        System.out.print("Ingrese el DNI del cliente a buscar: ");
        String dni = scan.next();
        Cliente encontrado = null;

        for (Cliente c : listaClientes)
            if(c.getDni().equals(dni)) {
                encontrado = c;
                break;
            }

        if(encontrado != null)
            System.out.println(encontrado.toString());
        else
            System.out.println("No hay ningun cliente con DNI " + dni);
    }
}
