package Main;

public class Producto {
    private String nombre;
    protected double precio;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String toString() {
        return "Nombre: " + this.nombre +
                ", Precio: " + this.precio;
    }

    public void calcular(int cantidadDeProductos) {
        double total = this.precio * cantidadDeProductos;
        System.out.println(total);
    }
}
