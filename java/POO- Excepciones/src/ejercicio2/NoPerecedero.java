package ejercicio2;

public class NoPerecedero extends Producto{
    private  String tipo;

    public NoPerecedero(String tipo) {
        this.tipo = tipo;
    }

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public NoPerecedero() {

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double calcular(int cantidadDeProductos){
        return cantidadDeProductos* this.getPrecio();
    }

    @Override
    public String toString() {
        return "NoPerecedero{" + "nombre=" + getNombre() +
                "tipo='" + tipo + "precio=" + getPrecio() + '\'' +
                '}';
    }
}
