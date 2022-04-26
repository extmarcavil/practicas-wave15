package categorias;

public class NoPerecederos extends Producto{
    private String tipo;

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public NoPerecederos(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public NoPerecederos(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public String toString() {
        return "NoPerecederos{" +
                "nombre='" + getNombre() + '\'' +
                ", precio=" + getPrecio() + '\'' +
                ", tipo='" + tipo +
                '}';
    }
}
