package EjercicioSuper;

import java.util.List;

public class Factura {
    private int dni;
    private List<Producto> listaProductos;
    private double total;

    public Factura() {
    }

    public Factura(int dni, List<Producto> listaProductos, double total) {
        this.dni = dni;
        this.listaProductos = listaProductos;
        this.total = total;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
