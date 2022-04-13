package HerenciaPolimorfismoYEncapsulamiento;

public class Producto {

    protected String nombre;
    protected double precio;

    public Producto(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre(){
        return nombre;
    }

    public double getPrecio(){
        return precio;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public String toString(){
        return "Nombre: " + getNombre() + " Precio: " + getPrecio();
    }

    public String calcular(int cantidadProducto)
    {
        double precioTotal = getPrecio() * cantidadProducto;
        return " El precio por " + cantidadProducto + " " + getNombre() + " es " + precioTotal;
    }


}
