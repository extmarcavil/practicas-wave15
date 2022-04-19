import java.util.ArrayList;
import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Item> listaItems;
    private double montoTotal;

    public Factura(Cliente cliente, List<Item> listaItems) {
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.montoTotal = listaItems.stream().mapToDouble(Item::getCostototal).sum();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public double getMontoTotal() {
        return montoTotal;
    }
}
