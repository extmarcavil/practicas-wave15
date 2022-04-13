package herency;

//Crear una clase Producto que cuente con los siguientes atributos:
// String nombre y double precio, la misma debe definir los métodos
// getters y setters para sus atributos, un constructor que reciba
// todos sus atributos como parámetro y el método toString(). Crear
// el método calcular() al cual vamos a pasarle un parámetro de tipo
// int llamado cantidadDeProductos; este método tiene que multiplicar
// el precio por la cantidad de productos pasados.

public class Producto {
    protected String nombre;
    protected double precio;

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
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    public double calcular(int cantidadDeProductos){
        return precio * cantidadDeProductos;
    }
}
