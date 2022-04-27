import java.util.ArrayList;

public class Factura {

    Cliente cliente;
    ArrayList<Producto> listProducts;
    double totalCompra;

    public Factura(Cliente cliente, ArrayList<Producto> listProducts, double totalCompra) {
        this.cliente = cliente;
        this.listProducts = listProducts;
        this.totalCompra = totalCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Producto> getListProducts() {
        return listProducts;
    }

    public void setListProducts(ArrayList<Producto> listProducts) {
        this.listProducts = listProducts;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public boolean buscarCliente(ArrayList<Cliente> listClients, Cliente cliente){
        boolean loEncontre = false;
        for (Cliente c : listClients) {
            if (cliente.getDni().equalsIgnoreCase(c.getDni())) {
                loEncontre =  true;
            }
        }

       return loEncontre;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", listProducts=" + listProducts +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
