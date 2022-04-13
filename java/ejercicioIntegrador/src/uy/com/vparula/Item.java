package uy.com.vparula;

public class Item {
    private int codigo;
    private String nombre;
    private int cantidadVendido;
    private double costoUnitario;

    public Item() {
    }

    public Item(int codigo, String nombre, int cantidadVendido, double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadVendido = cantidadVendido;
        this.costoUnitario = costoUnitario;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadVendido() {
        return cantidadVendido;
    }

    public void setCantidadVendido(int cantidadVendido) {
        this.cantidadVendido = cantidadVendido;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }
}
