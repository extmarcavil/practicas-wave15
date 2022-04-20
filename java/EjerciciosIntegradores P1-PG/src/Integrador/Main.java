package Integrador;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {


    //Recibe una lista con los clientes y los imprime uno por uno
    public static void imprimirClientes(List<Cliente> lista){
        lista.stream()
                .forEach(System.out::println);
    }

    //Solicita y devuelve la entrada de un DNI
    public static Integer pedirDni(Scanner scan){
        Integer dniPedido = 0;
        System.out.println("Ingrese un DNI: ");
        dniPedido = scan.nextInt();
        return dniPedido;
    }

    //Solicita y devuelve la entrada de un nombre
    public static String pedirNombre(Scanner scan){
        String nombrePedido = "";
        System.out.println("Ingrese un nombre: ");
        nombrePedido = scan.next();
        return nombrePedido;
    }

    //Recibe una lista con clientes y en base a un DNI lo busca en la lista.
    //Devuelve al cliente en caso de encontrarlo o null si no existe.
    public static Cliente buscarCliente(List<Cliente> lista, Scanner scan){
        Integer dniPedido = pedirDni(scan);

        Cliente solicitado = lista.stream()
                .filter(x -> dniPedido.equals(x.getDni()))
                .findAny()
                .orElse(null);

        return solicitado;
    }

    public static void main(String[] args){
        //Creo la collection para los clientes y a 3 clientes.
        List<Cliente> collectionClientes = new ArrayList<>();
        Cliente juan = new Cliente(40123456, "Juan Perez");
        Cliente pedro = new Cliente(41123456, "Pedro Perez");
        Cliente jorge = new Cliente(42123456, "Jorge Perez");

        //Agrego los clientes a la collection
        collectionClientes.add(juan);
        collectionClientes.add(pedro);
        collectionClientes.add(jorge);

        //Muestro los clientes
        imprimirClientes(collectionClientes);

        //Elimino un cliente
        collectionClientes.remove(pedro);

        //Muestro la lista modificada
        imprimirClientes(collectionClientes);


        //Ingreso un DNI, lo busco en la lista y si lo encuentro lo imprimo.
        Scanner scan = new Scanner(System.in);
        Cliente solicitado = buscarCliente(collectionClientes, scan);

        if(solicitado == null){
            System.out.println("No se ha encontrado al cliente");
        }else{
            System.out.println(solicitado);
        }

        //Para crear la factura, busco al cliente al que se la voy a asignar. Si no lo encuentro lo creo.
        Cliente clienteParaValidar = buscarCliente(collectionClientes, scan);
        if(clienteParaValidar == null){
            Integer dni = pedirDni(scan);
            String nombre = pedirNombre(scan);
            Cliente cliente = new Cliente(dni, nombre);
            Factura factura = new Factura(cliente);
        }
        scan.close();
        Factura factura = new Factura(clienteParaValidar);

        Item queso = new Item(001, "queso", 1, 400);
        Item tomate = new Item(002, "tomate", 4, 50);
        Item fideos = new Item(003, "fideos", 2, 300);
        Item crema = new Item(004, "crema", 1, 250);

        factura.agregarItemALista(queso);
        factura.agregarItemALista(tomate);
        factura.agregarItemALista(fideos);
        factura.agregarItemALista(crema);

        Integer total = factura.getListaItems().stream()
                .mapToInt(x -> x.devolverCostoProducto())
                .sum();
        System.out.println(total);


    }

}
