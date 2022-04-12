import java.util.List;

public class Factura {
    Cliente cliente;
    List<Item> listaItems;
    double montoTotal;

    public Factura(Cliente cliente, List<Item> listaItems, double montoTotal) {
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.montoTotal = montoTotal;
    }
}
