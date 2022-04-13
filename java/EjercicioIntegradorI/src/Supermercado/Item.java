package Supermercado;

public class Item {
    private String codigo;
    private String nombre;
    private int cantidadComprado;
    private float precioUnitario;

    public Item(String codigo, String nombre, int cantidadComprado, float precioUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComprado = cantidadComprado;
        this.precioUnitario = precioUnitario;
    }

    public String toString(){
        return nombre + ", " + codigo + ", " + cantidadComprado + " unidades, $" + precioUnitario + " c/u";
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

    public int getCantidadComprado() {
        return cantidadComprado;
    }

    public void setCantidadComprado(int cantidadComprado) {
        this.cantidadComprado = cantidadComprado;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public float getCostoTotal () {return cantidadComprado * precioUnitario;}
}
