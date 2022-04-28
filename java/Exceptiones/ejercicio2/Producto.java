package ejercicio2;

public class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public double calcular(int cantidadDeProductos) {
        return this.precio * cantidadDeProductos;
    }

    public String toString() {
        return "Nombre: " + this.getNombre() + " Precio: " + this.getPrecio();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
