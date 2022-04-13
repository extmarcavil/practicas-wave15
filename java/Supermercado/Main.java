package Supermercado;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1= new Cliente(390000L,"fulanito","mengano");
        Cliente cliente2= new Cliente(400000L,"fulanito2","mengano2");
        Cliente cliente3= new Cliente(500000L,"fulanito3","mengano3");
        ArrayList<Cliente> listadoClientes= new ArrayList<>();
        listadoClientes.add(cliente1);
        listadoClientes.add(cliente2);
        listadoClientes.add(cliente3);
        //listadoClientes.forEach(System.out::println);
        for (Cliente cliente: listadoClientes) {
            System.out.println("DNI: " + cliente.getDni());
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Apellido: "+ cliente.getApellido());
            System.out.println("---------------------");
        }
        /*System.out.println("Listado despues de borrar el primer cliente");
        listadoClientes.remove(0);
        for (Cliente cliente: listadoClientes) {
            System.out.println("DNI: " + cliente.getDni());
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Apellido: "+ cliente.getApellido());
            System.out.println("---------------------");
        }*/
        System.out.println("Ingrese el dni que desea borrar");

        Scanner teclado = new Scanner(System.in);
        Long dniBorrar= teclado.nextLong();

        if (!listadoClientes.removeIf(cliente -> cliente.getDni().equals(dniBorrar))) {
            System.out.println("El cliente ingresado no se encuentra.");
        }else{
            System.out.println("Listado despues de borrar el cliente ingresado");
            for (Cliente cliente: listadoClientes) {
                System.out.println("DNI: " + cliente.getDni());
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("Apellido: "+ cliente.getApellido());
                System.out.println("---------------------");
            }
        }
        boolean bandera=false;
        Long dniBuscar = teclado.nextLong();
        for (Cliente clientes: listadoClientes) {
            if(clientes.getDni().equals(dniBuscar)){
                System.out.println("Cliente encontrado");
                bandera=true;
                break;
            }
        }
        if(!bandera){
            System.out.println("Cliente no encontrado");
        }

        /*Item item1= new Item(1,"item1",2,100);
        Item item2= new Item(2,"item2",1,50);
        Item item3= new Item(3,"item3",4,200);
        ArrayList<Item> listadoItems= new ArrayList<>();
        listadoItems.add(item1);
        listadoItems.add(item2);
        listadoItems.add(item3);
        Factura f1= new Factura(1,100,cliente1,listadoItems);
        Factura f2= new Factura(2,100,cliente2,listadoItems);*/


    }
}
