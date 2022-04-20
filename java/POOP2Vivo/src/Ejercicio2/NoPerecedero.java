package Ejercicio2;

public class NoPerecedero extends Producto{

    private String tipo;
    private String nombre;
    private double precio;

    public NoPerecedero(String nombre, double precio, String tipo){
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){
        return this.tipo;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double calcular(int cantidadDeProductos){
        return (this.precio * cantidadDeProductos);
    }
}
