package DistribucionProductos;

public class Producto {

    private String  nombre;
    private double  precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        precio = precio;
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
        precio = precio;
    }


    public void calcular(int cantidadDeProductos){
        double precioTotal = this.precio*cantidadDeProductos;
    }



}
