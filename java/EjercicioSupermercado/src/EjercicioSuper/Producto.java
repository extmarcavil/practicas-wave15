package EjercicioSuper;

public class Producto {
    private String codigo;
    private String nombre;
    private double costoUnitario;
    private int cantidadComprada;

    public Producto() {
    }

    public Producto(String codigo, String nombre, double costoUnitario, int cantidadComprada) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.costoUnitario = costoUnitario;
        this.cantidadComprada = cantidadComprada;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }
}
