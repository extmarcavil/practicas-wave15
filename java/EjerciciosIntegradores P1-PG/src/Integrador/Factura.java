package Integrador;

import java.util.ArrayList;
import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Item> listaItems;
    private int totalDeCompra;

    public Factura(Cliente cliente){
        this.cliente = cliente;
        this.listaItems = new ArrayList<>();
        this.totalDeCompra = 0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public int getTotalDeCompra() {
        return totalDeCompra;
    }

    public void setTotalDeCompra(int totalDeCompra) {
        this.totalDeCompra = totalDeCompra;
    }

    public void agregarItemALista(Item item){
        totalDeCompra += item.devolverCostoProducto();
        this.listaItems.add(item);
    }
}
