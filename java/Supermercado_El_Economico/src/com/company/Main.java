package com.company;

import com.company.model.Cliente;
import com.company.model.Factura;
import com.company.model.Item;
import com.company.repository.ClienteImpl;
import com.company.repository.FacturaImpl;
import com.company.repository.ItemImpl;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here


        /**
         * PARTE 1 SUPERMERCADO "EL ECONOMICO"
         */
        System.out.println("PARTE 1 SUPERMERCADO \"EL ECONOMICO\"" + "\n");
        /**
         * Creando los clientes y agregandolos a una Bd.
         */

        //Instancia de la clase Scanner.
        Scanner tecladoUser = new Scanner(System.in);

        //Implementacion de ClienteImpl, FacturaImpl, ItemImpl
        ClienteImpl implementandoCliente = new ClienteImpl();
        FacturaImpl implFacturas = new FacturaImpl(implementandoCliente);
        ItemImpl implItems = new ItemImpl();

        //Clientes
        System.out.println("Creando los clientes y agregandolos a la Base de Datos ");
        Cliente pedro = new Cliente(123, "pedro", "perez");
        Cliente pablo = new Cliente(456, "pablo", "correa"); //Cliente aun no ha sido agregado a la BD.
        Cliente eduardo = new Cliente(987, "eduardo", "tirado");

        //Guardando cliente.
        implementandoCliente.save(pedro);
        //implementandoCliente.save(pablo); //Cliente aun no ha sido agregado a la BD.
        implementandoCliente.save(eduardo);

        /**
         * Recorriendo la collection de clientes y mostrando sus datos.
         */
        System.out.println("\n");
        System.out.println("Imprimiendo por pantalla cada cliente de la Base de Datos " + "\n");
        implementandoCliente.mostrarPorPantalla();

        /**
         * Buscando un cliente por Dni.
         */
        //Utilizando el Scanner dniIngresado.
        System.out.println("Ingrese el Dni del cliente a Buscar ");
        int dniAbuscar = tecladoUser.nextInt();
        System.out.println("Buscando el cliente en la base de datos ");
        System.out.println(implementandoCliente.buscarPorId(dniAbuscar));

        /**
         * Eliminando un cliente e imprimiendo la lista nuevamente.
         */
        System.out.println("\n");
        System.out.println("Ingrese el dni del cliente a eliminar " + "\n");
        int dniEliminar = tecladoUser.nextInt();
        System.out.println("Eliminando el cliente " + "\n");
        implementandoCliente.delete(dniEliminar);

        /**
         * Imprimiendo la BD Actualizada
         */
        System.out.println("Imprimiendo la base de datos de clientes Actualizada" + "\n");
        System.out.println(implementandoCliente.mostrarTodos());


        System.out.println("/******************************************/");


        /**
         * PARTE 2 SUPERMERCADO "EL ECONOMICO"
         */
        System.out.println("PARTE 2 SUPERMERCADO \"EL ECONOMICO\"" + "\n");//Agregando Items a la lista de Pedro.

        //Agregando Items a la BD .
        Item telefono = new Item("ip11", "Iphone", 2, 3000.0);
        Item telefono2 = new Item("ip12", "Iphone", 2, 5000.0);
        Item auto = new Item("aut2", "audi", 1, 50000.0);

        implItems.save(telefono);
        implItems.save(telefono2);

        //Repository de Items 2 (itemImpl2) Agregando Items  Bd.
        ItemImpl itemImpl2 = new ItemImpl();
        itemImpl2.save(auto);


        //Agregando facturas a mi base de datos
        Factura facTelefono = new Factura(pedro, implItems.getListaDeItems());
        Factura facAuto = new Factura(pablo, itemImpl2.getListaDeItems());

        //Validando si el cliente asociado a la factura se encuentra registrado en la BD:
        implFacturas.save(facTelefono); //Cliente es Pedro ya registrado en Bd anteriormente
        implFacturas.save(facAuto);  // Cliente Pablo no registrado en Bd

        //Calculando el total de cada factura
        implFacturas.getListaDeFacturas().stream().forEach( factura -> {
            factura.calcularTotalDelaCompra();
            System.out.println("Informacion de la factura: " + factura + "\n");
        });




        System.out.println(/******************************************/);


        /**
         * Validando si el cliente esta registrado en Base de datos de Clientes.
         * En caso de que no este, debera ser creado

         facturasRealizadas.stream().forEach(factura -> {
         if (listaDeClientes.contains(factura.getCliente())) {
         System.out.println("El cliente " + factura.getCliente().getNombre() + " ya se encuentra registrado en la base de datos " + "\n");
         } else {
         listaDeClientes.add(factura.getCliente());
         System.out.println("El cliente " + factura.getCliente().getNombre() + " ha sido almacenado en la base de datos " + "\n");
         }
         });

         /**
         * Imprimiendo por pantalla el total de las compras hechas por cada uno de los clientes.

         //Calculando el valor total de cada factura

         facturasRealizadas.stream().forEach(factura -> {
         factura.calcularTotalDelaCompra();
         System.out.println("Informacion de la factura del " + factura + "\n");

         });
         */


    }
}
