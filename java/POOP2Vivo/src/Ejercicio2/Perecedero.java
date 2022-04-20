package Ejercicio2;

public class Perecedero extends Producto {

    private String nombre;
    private double precio;
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int dias){
        this.nombre = nombre;
        this.precio = precio;
        this.diasPorCaducar = dias;
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

    public void setDiasPorCaducar(int dias){
        this.diasPorCaducar = dias;
    }

    public int getDiasPorCaducar(){
        return getDiasPorCaducar();
    }

    public double calcular(int cantidadDeProductos){
        double costo = 0;
        costo = this.precio * cantidadDeProductos;
        if(this.diasPorCaducar == 1){
            costo = costo/4;
        }else if(this.diasPorCaducar == 2){
            costo = costo/3;
        }else if(this.diasPorCaducar == 3){
            costo = costo/2;
        }
        return costo;
    }

}
