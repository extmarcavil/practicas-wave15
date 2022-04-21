
public class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
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

    @Override
    public String toString() {
        return "Nombre='" + nombre + '\'' +
                ", precio=" + precio + '\'';
    }

    //Método calcular, se le pasa un parámetro de tipo int que multiplica el precio por la cantidad de productos pasados.
    public double calcular(int cantidadDeProductos) {
        return this.precio * cantidadDeProductos;
    }
}

