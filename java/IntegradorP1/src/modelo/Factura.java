package modelo;

import java.util.List;

public class Factura {

    private String codigo;
    private Cliente cli;
    private List<Item> listaItems;
    private double total;

    public Factura() {
    }

    public Factura(String codigo, Cliente cli, List<Item> listaItems, double total) {
        this.codigo = codigo;
        this.cli = cli;
        this.listaItems = listaItems;
        this.total = total;
    }

    public String  getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
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
                "codigo='" + codigo + '\'' +
                ", cli=" + cli +
                ", listaItems=" + listaItems +
                ", total=" + total +
                '}';
    }
}
