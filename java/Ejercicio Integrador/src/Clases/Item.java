package Clases;

public class Item {
    private int codigo, cantidad_comprada;
    private double costo_unitario;
    private String nombre;

    public Item(int codigo, int cantidad_comprada, double costo_unitario, String nombre) {
        this.codigo = codigo;
        this.cantidad_comprada = cantidad_comprada;
        this.costo_unitario = costo_unitario;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCantidad_comprada() {
        return cantidad_comprada;
    }

    public double getCosto_unitario() {
        return costo_unitario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCantidad_comprada(int cantidad_comprada) {
        this.cantidad_comprada = cantidad_comprada;
    }

    public void setCosto_unitario(double costo_unitario) {
        this.costo_unitario = costo_unitario;
    }
}
