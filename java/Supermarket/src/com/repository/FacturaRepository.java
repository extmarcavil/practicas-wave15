package com.repository;

import com.models.Cliente;
import com.models.Factura;
import com.repository.CRUD;
import java.util.List;
import java.util.Scanner;

public class FacturaRepository implements CRUD<Factura> {

    private Scanner in = new Scanner(System.in);
    @Override
    public Factura registrarElemento() {
        return null;
    }

    @Override
    public Factura chequearElemento(List clientes) {
        return null;
    }

    @Override
    public Factura registrarFactura(Cliente client, List items, double total) {
        System.out.println(" ");
        System.out.println("--------------------------------");
        System.out.println(" ");
        System.out.println("Crear factura");
        System.out.println(" ");
        System.out.println("Ingrese el codigo de la factura");
        int code = in.nextInt();
        Factura factura = new Factura(client, code, items,total);
        return factura;
    }


    @Override
    public void mostrarPantalla(List<Factura> facturas) {
        for (Factura c1 : facturas) {
            System.out.println(c1);
        }
    }

    @Override
    public void eliminarElemnto(List<Factura> elem) {

        System.out.println("Ingrese el codigo de la factura que desea eliminar");
        try {
            int cod = in.nextInt();
            elem.remove(elem.stream().filter(x -> x.getCodigo() == cod).findAny().orElse(null));
            System.out.println("Se ha eliminado correctamente");
        } catch (Exception e) {
            System.out.println("No ingreso un codigo valido");
        }
    }
}
