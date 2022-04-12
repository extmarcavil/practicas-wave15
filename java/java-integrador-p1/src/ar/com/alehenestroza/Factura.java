package ar.com.alehenestroza;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double precioTotal;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        items = new ArrayList<Item>();
        precioTotal = 0;
    }

    public void addItem(Item item) {
        this.items.add(item);
        precioTotal += item.getPrecioUnitario() * item.getCantidadComprada();
    }
}
