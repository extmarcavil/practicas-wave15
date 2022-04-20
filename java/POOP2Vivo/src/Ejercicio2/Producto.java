package Ejercicio2;

public class Producto {
    private String nombre;
    private double precio;

    public Producto(){

    }

    public Producto(String nombreProducto, double precioProducto){
        this.nombre = nombreProducto;
        this.precio = precioProducto;
    }

    public String getNombre(){
        return this.nombre;
    }

    public double getPrecio(){
        return this.precio;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public String toString(){
        return this.toString();
    }

    public double calcular(int cantidadDeProductos){
        return (this.precio * cantidadDeProductos);
    }

}
