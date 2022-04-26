package categorias;

public class Producto {
    private String nombre;
    private double precio;

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getPrecio(){
        return nombre;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public Producto(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    public double Calcular(int cantidadDeProductos){
        return cantidadDeProductos * precio;
    }
}
