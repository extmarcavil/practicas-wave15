package ejercicio2;

public class Producto {

    private String  nomnbre;
    private double precio;

    public Producto() {
    }

    public Producto(String nomnbre, double precio) {
        this.nomnbre = nomnbre;
        this.precio = precio;
    }

    public String getNomnbre() {
        return nomnbre;
    }

    public void setNomnbre(String nomnbre) {
        this.nomnbre = nomnbre;
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
                "nomnbre='" + nomnbre + '\'' +
                ", precio=" + precio +
                '}';
    }

    public double calcular(int cantidadDeProductos){
        return cantidadDeProductos*precio;
    }
}
