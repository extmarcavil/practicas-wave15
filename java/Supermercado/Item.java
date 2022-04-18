package Supermercado;

public class Item {
    private Long codigo;
    private String nombre;
    private int cant;
    private double constoUnitario;

    public Item() {
    }

    public Item(Long codigo, String nombre, int cant, double constoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cant = cant;
        this.constoUnitario = constoUnitario;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
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

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", cant=" + cant +
                ", constoUnitario=" + constoUnitario +
                '}';
    }
}
