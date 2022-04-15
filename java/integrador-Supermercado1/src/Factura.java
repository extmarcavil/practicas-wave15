import java.util.ArrayList;
import java.util.List;

public class Factura {

    private Cliente cliente;
    private double total = 0;
    private String codigo;
    private List<Producto> productos;

    public Factura(String codigo,Cliente cliente, List<Producto> productos) {
        this.cliente = cliente;
        this.productos = productos;
        this.codigo=codigo;
        for (Producto p : productos){
            total+=p.getCantidad()*p.getCostoUnitario();
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {

        StringBuilder factura;
        factura = new StringBuilder("Factura{" +
                "cliente=" + cliente +
                ", total=" + total +
                ", codigo='" + codigo + '\'' +
                ", productos=");
                for (Producto p : productos){
                    factura.append(p.toString()).append('\'');
                }
                factura.append('}');
                return factura.toString();
    }
}
