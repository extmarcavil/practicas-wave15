import Clases.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        //Crear 3 clientes y guardarlos en una collección.
        listaClientes.add(new Cliente("1233904572","Juan","Chaparro"));
        listaClientes.add(new Cliente("1233910998","Andrea","Moreno"));
        listaClientes.add(new Cliente("1000236579","Pablo","Cardozo"));

        //Mostrar por pantalla todos los clientes
        listaClientes.stream().forEach(p -> System.out.println(p.toString()));
        System.out.println("---------------------");

        //Eliminar uno de los clientes de la lista y volver a consultar e imprimir.
        listaClientes.remove(1);
        listaClientes.stream().forEach(p -> System.out.println(p.toString()));
        System.out.println();

        //Solicitar por teclado un numero de DNI de un cliente para buscarlo.
        Scanner teclado = new Scanner(System.in);
        System.out.println("Por favor digite un DNI a consultar");
        String searchDni = teclado.nextLine();
        List<Cliente> result = listaClientes.stream().filter(p -> p.getDni().equals(searchDni)).collect(Collectors.toList());
        if (result.size() > 0){
            System.out.println("Usuario encontrado:");
            result.stream().forEach(p -> System.out.println(p.toString()));
        } else{
            System.out.println("No se ha encontrado el cliente");
        }
    }
}
