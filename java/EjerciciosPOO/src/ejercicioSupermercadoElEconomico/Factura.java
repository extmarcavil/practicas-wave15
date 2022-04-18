package ejercicioSupermercadoElEconomico;

import java.util.ArrayList;

public class Factura {
    private Cliente cliente;
    private ArrayList<Item> listaItems = new ArrayList<>();
    private double totalCompra = 0;

    public Factura() {
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void addCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addItem(Item item) {
        this.listaItems.add(item);
    }

    public void calcularTotal() {
        this.totalCompra = this.listaItems.stream().mapToDouble(item -> item.getCostoUnitario()* item.getCantidad()).sum();
    }

    @Override
    public String toString() {
        return "Factura{\n" +
                cliente.toString() +
                ", \nlistaItems=" + listaItems.toString() +
                ", \ntotalCompra=" + totalCompra +
                '}';
    }
}
