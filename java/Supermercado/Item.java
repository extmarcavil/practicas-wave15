package Supermercado;

public class Item {
    private long codigo;
    private String nombre;
    private int cant;
    private double constoUnitario;

    public Item() {
    }

    public Item(long codigo, String nombre, int cant, double constoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cant = cant;
        this.constoUnitario = constoUnitario;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getConstoUnitario() {
        return constoUnitario;
    }

    public void setConstoUnitario(double constoUnitario) {
        this.constoUnitario = constoUnitario;
    }
}
