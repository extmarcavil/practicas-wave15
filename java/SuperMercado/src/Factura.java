import java.util.ArrayList;

public class Factura {
    //region Atributos
    private  int CodigoFactura;
    private Cliente Cliente;
    private  ArrayList<Producto> ListProductos;
    private  double TotalCompra;
    //endregion

    //region Constructor

    public Factura(int codigoFactura, Cliente cliente, ArrayList<Producto> listProductos, double totalCompra) {
        CodigoFactura = codigoFactura;
        Cliente = cliente;
        ListProductos = listProductos;
        TotalCompra = totalCompra;
    }


    //endregion

    //region Getters setters


    public int getCodigoFactura() {
        return CodigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        CodigoFactura = codigoFactura;
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente cliente) {
        Cliente = cliente;
    }

    public ArrayList<Producto> getListProductos() {
        return ListProductos;
    }

    public void setListProductos(ArrayList<Producto> listProductos) {
        ListProductos = listProductos;
    }

    public double getTotalCompra() {
        return TotalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        TotalCompra = totalCompra;
    }


    //endregion


    @Override
    public String toString() {
        return "Factura{" +
                "CodigoFactura=" + CodigoFactura +
                ", Cliente=" + Cliente +
                ", ListProductos=" + ListProductos +
                ", TotalCompra=" + TotalCompra +
                '}';
    }
}
