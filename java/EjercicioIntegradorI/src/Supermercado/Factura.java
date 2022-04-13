package Supermercado;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double totalCompra;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        this.totalCompra = items.stream().mapToDouble(Item::getCostoTotal).sum();
    }

    public String toString(){
        String result = cliente.toString();
        for (Item item : items){
            result += "\n\t"+item.toString();
        }
        result += "\nTotal compra: $" + totalCompra;
        return result;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }
}
