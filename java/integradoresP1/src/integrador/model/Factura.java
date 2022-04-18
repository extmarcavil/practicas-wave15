package integrador.model;

import java.util.List;

public class Factura {

    private static Integer contador=0;
    private Integer idFactura;
    private Cliente cliente;
    private List<Item> items;
    private Double montoTotal;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        this.idFactura=getId();
    }

    public Integer getIdFactura() {
        return idFactura;
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

    public Double getMontoTotal() {
        if (montoTotal == null) {
            montoTotal=items.stream()
                    .mapToDouble(item -> item.getCostoUnitario()*item.getCantidad())
                    .sum();
        }
        return montoTotal;
    }

    public static Integer getId(){
        return ++contador;
    }
}
