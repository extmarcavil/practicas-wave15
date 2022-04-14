package ejercicioIntegradorParte1YParte2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List <Cliente> clientes = new ArrayList<>();
        List <Item> items = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean existe = false;

        clientes.add(new Cliente("123","Carl","Carson"));
        clientes.add(new Cliente("456","Barni","Gambol"));
        clientes.add(new Cliente("789","Nelson","Mont"));

        items.add(new Item("001","Arroz",1,2500));
        items.add(new Item("002","Maiz",2,2000));
        items.add(new Item("003","Aceite",1,20500));
        items.add(new Item("004","Frijol",3,1500));



        clientes.forEach(c -> System.out.println(c));

        System.out.println("Introduzca el dni a borrar");
        String dni = sc.nextLine();

        Cliente.eliminarCliente(clientes,dni);

//        for (Cliente c:clientes) {
//            if(c.getDni().equals(dni)){
//                clientes.remove(c);
//                existe = true;
//                break;
//            }
//        }
//
//        if(existe){
//            System.out.println("Usuario eliminado correctamente");
//        }else {
//            System.out.println("No se enconttro el usuario");
//        }
//
//        existe = false;

        System.out.println("----------------------");
        clientes.forEach(c -> System.out.println(c));



        System.out.println("Introduzca el dni a buscar");
        dni = sc.nextLine();

        Cliente clienteBuscado = Cliente.buscarCliente(clientes,dni);
        if(clienteBuscado == null){
            System.out.println("El cliente no existe");
        }else{
            System.out.println(clienteBuscado);
        }

//            for (Cliente cliente : clientes) {
//                if (cliente.getDni().equals(dni)) {
//                    System.out.println(cliente);
//                    existe = true;
//                    break;
//                }
//            }
//
//            if (!existe) {
//                System.out.println("Usuario no encontrado");
//            }

        System.out.println("Introducir dni del cliente");
        dni = sc.nextLine();
        Cliente clNew = Cliente.buscarCliente(clientes,dni);
        if(clNew == null){
          clNew = Cliente.crearCliente();
          clientes.add(clNew);
        }

        Factura factura = new Factura(clNew,items);
        System.out.println(factura.getTotalCompra());










        sc.close();

    }
}

