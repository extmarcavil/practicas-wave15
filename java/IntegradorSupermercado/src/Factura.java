import java.util.List;

public class Factura {

    private Long codigo;
    private Cliente cliente;
    private List<Item> listaItems;
    private Double total;

    public Factura() {
    }

    public Factura(Long codigo, Cliente cliente, List<Item> listaItems, Double total) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.total = total;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
