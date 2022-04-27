package integradora;

public class NoPerecedero extends Producto{
    String tipo;

    public NoPerecedero(String tipo, double precio, String nombre) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "NoPerecedero{" +
                "tipo='" + tipo + '\'' +
                "precio=" + getPrecio() +
                "nombre=" + getNombre() +
                '}';
    }
}
