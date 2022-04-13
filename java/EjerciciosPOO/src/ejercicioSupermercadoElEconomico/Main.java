package ejercicioSupermercadoElEconomico;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Elias", "Chaparro", "34343434"));
        clientes.add(new Cliente("Juana", "Pizarro", "34333231"));
        clientes.add(new Cliente("Kevin", "Chuca", "34353637"));

        clientes.stream().forEach(System.out::println);
        System.out.println();

        clientes.remove(1);
        clientes.stream().forEach(System.out::println);

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el DNI a buscar: ");
        String dni = sc.nextLine();
        sc.close();
        try {
            System.out.println(clientes.stream().filter(cliente -> cliente.getDni().equals(dni)).findFirst().get());
        } catch (NoSuchElementException e) {
            System.out.println("Dni de cliente no encontrado");
        }

    }
}
