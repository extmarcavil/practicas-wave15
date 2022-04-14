package com.models;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.models.Item;

public class Factura{
    private int codigo;
    private Cliente cliente;
    private Item item;
    private List<Item> itemsList = new ArrayList<Item>();
    private double total;
    private Scanner in = new Scanner(System.in);


    public Factura(Cliente cliente, int codigo, List<Item> itemsList, double total) {
        this.cliente = cliente;
        this.codigo = codigo;
        this.itemsList = itemsList;
        this.total = total;
    }

    public Factura() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Item> itemsList) {
        this.itemsList = itemsList;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", itemsList=" + itemsList +
                ", total=" + total +
                '}';
    }


}
