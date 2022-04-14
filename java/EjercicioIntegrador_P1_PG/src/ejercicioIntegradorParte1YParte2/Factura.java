package ejercicioIntegradorParte1YParte2;

import java.util.ArrayList;
import java.util.List;

public class Factura {

    private Cliente cliente;
    private List <Item> items = new ArrayList<>();
    private double totalCompra = calcularTotalCompra(items);

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
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
        return calcularTotalCompra(items);
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public double calcularTotalCompra (List<Item> itemss){
        double totalCompra1 = 0;
        for (Item i: itemss) {
            totalCompra1 += i.getCostoUnitario()* i.getCantidadComprada();
        }
        return totalCompra1;
    }



}
