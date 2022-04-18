package modelo;

public class Item {

    private String codigo;
    private String nombre;
    private int cant;
    private double costoUnit;

    public Item() {
    }

    public Item(String codigo, String nombre, int cant, double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cant = cant;
        this.costoUnit = costoUnitario;
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

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getCostoUnit() {
        return costoUnit;
    }

    public void setCostoUnit(double costoUnit) {
        this.costoUnit = costoUnit;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cant=" + cant +
                ", costoUnit=" + costoUnit +
                '}';
    }
}
