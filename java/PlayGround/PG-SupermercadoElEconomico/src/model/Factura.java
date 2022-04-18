package model;

import java.util.ArrayList;

public class Factura {

    Cliente cliente;
    ArrayList<Item> listaDeItems;
    double totalDeLaCompra;
    int numeroDeFactura;


    public Factura(Cliente clienteAFacturar, ArrayList<Item> listaDeItems,int numeroDeFactura) {
        this.cliente = clienteAFacturar;
        this.listaDeItems = listaDeItems;
        this.numeroDeFactura = numeroDeFactura;
        this.totalDeLaCompra = 0;
        this.totalDeLaCompra = listaDeItems.stream().map(Item::getCostototal).reduce(totalDeLaCompra,Double::sum);
    }

    public Double getTotal(){
        return totalDeLaCompra;
    }

    public Integer getNumeroDeFactura() {
        return numeroDeFactura;
    }
}
