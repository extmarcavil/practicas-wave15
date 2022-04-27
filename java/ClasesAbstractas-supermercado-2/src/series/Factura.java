package series;

import java.util.ArrayList;

public class Factura {
    Cliente cliente;
    ArrayList<Item> items;
    double total;

    public Factura(Cliente cliente, ArrayList<Item> items) {
        this.cliente = cliente;
        this.items = items;
        this.total = getTotal();
    }

    public double getTotal(){
        return this.items.stream()
                .mapToDouble(item -> item.costoUnitario * item.cantidad)
                .sum();
    }
}
