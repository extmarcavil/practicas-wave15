package ejercicio2;

import java.util.ArrayList;

public class Producto {

    private String  nombre;
    private double precio;

    public Producto() {
    }

    public Producto(String nomnbre, double precio) {
        this.nombre = nomnbre;
        this.precio = precio;
    }

    public String getNomnbre() {
        return nombre;
    }

    public void setNomnbre(String nomnbre) {
        this.nombre = nomnbre;
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
        return cantidadDeProductos*precio;
    }
}
