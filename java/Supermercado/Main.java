package Supermercado;

import Supermercado.repository.ClienteImp;
import Supermercado.repository.FacturaImp;
import Supermercado.repository.ItemImp;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1= new Cliente(390000L,"fulanito","mengano");
        Cliente cliente2= new Cliente(400000L,"fulanito2","mengano2");
        Cliente cliente3= new Cliente(500000L,"fulanito3","mengano3");
        ClienteImp clienteImp = new ClienteImp();
        clienteImp.save(cliente1);
        clienteImp.save(cliente2);
        clienteImp.mostrarDatos();
        System.out.println("Ingrese el dni que desea borrar");
        Scanner teclado = new Scanner(System.in);
        Long dniBorrar= teclado.nextLong();

        clienteImp.eliminar(dniBorrar);
        System.out.println("Ingese el dni a buscar:");
        Long dniBuscar = teclado.nextLong();
        clienteImp.buscar(dniBuscar);
        Item item1 = new Item(1L,"item 1",2,300);
        ItemImp itemImp = new ItemImp();
        itemImp.save(item1);
        Factura fact1 = new Factura(1L,itemImp.calcularTotal(),cliente3,itemImp.mostrarTodosObjetos());
        FacturaImp facturaImp = new FacturaImp();
        facturaImp.saveWithValidate(clienteImp,fact1);
        System.out.println("Listado de Facturas");
        facturaImp.mostrarDatos();
        System.out.println("--------------------------");
        System.out.println("Listado Clientes");
        clienteImp.mostrarDatos();
        System.out.println("--------------------------");



    }
}
