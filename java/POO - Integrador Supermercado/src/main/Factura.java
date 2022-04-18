package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Factura {
    private int numero;
    private char tipo;
    private Cliente cliente;
    private double total = 0;
    private List<Item> listadoItems = new ArrayList<>();
    private int contFacturas = 0;

    public Factura(){

    }

    public Factura(char tipo, Cliente cliente, List<Item> listadoItems) {
        this.numero = contFacturas+1;
        this.tipo = tipo;
        this.cliente = cliente;
        this.listadoItems = listadoItems;
        for (Item item : listadoItems){
            this.total += (item.getCantidad() * item.getPrecio());
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Item> getListadoItems() {
        return listadoItems;
    }

    public void setListadoItems(List<Item> listadoItems) {
        this.listadoItems = listadoItems;
    }

    public void verDetalle(List<Item> listadoItems){
        System.out.println("Detalle Productos: ");
        for (Item item : listadoItems){
            System.out.println("Nombre: " + item.getNombre() + " -- Cantidad: " + item.getCantidad());
        }
    }

    @Override
    public String toString() {
        return "Factura: " +
                "\nNumero: " + numero +
                "\nTipo: " + tipo +
                "\nCliente: " + cliente.getNombre() + " " + cliente.getApellido() + " " + cliente.getDni() +
                "\nTotal: $" + total;
                //"\nDetalleProductos:" + "\n" + listadoItems.toString();
    }
}
