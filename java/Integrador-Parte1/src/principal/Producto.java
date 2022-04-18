package principal;

public class Producto {
    private int código;
    private String nombre;
    private int cantidad;
    private float costo;

    public Producto(int código, String nombre, int cantidad, int costo) {
        this.código = código;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public int getCódigo() {
        return código;
    }

    public void setCódigo(int código) {
        this.código = código;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getCosto() {
        return this.cantidad * costo;
    }

    public void setCosto(int costoUnitario) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "código=" + código +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", costo=" + costo +
                '}';
    }
}

