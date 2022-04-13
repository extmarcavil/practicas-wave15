package HerenciaPolimorfismoYEncapsulamiento;

public class NoPrecedero extends Producto {

    protected String tipo;

    public NoPrecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String toString() {
        return super.toString() + " Tipo " + getTipo();
    }

    @Override
    public String calcular(int cantidadProducto)
    {
        double precioTotal = getPrecio() * cantidadProducto;
        return " El precio por " + cantidadProducto + " " + getNombre() + "  es " + precioTotal;
    }
}
