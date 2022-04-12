import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Cliente cliente;
    private int codigo;
    private List<Item> itemsList = new ArrayList<Item>();
    private double total;

    public Factura(Cliente cliente, int codigo, List<Item> itemsList, double total) {
        this.cliente = cliente;
        this.codigo = codigo;
        this.itemsList = itemsList;
        this.total = total;
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
