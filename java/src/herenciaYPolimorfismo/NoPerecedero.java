package herenciaYPolimorfismo;

public class NoPerecedero extends Producto{
    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    String tipo;

    public NoPerecedero(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        return super.calcular(cantidadDeProductos);
    }


    @Override
    public String toString() {
        return "NoPerecedero {" +
                "tipo='" + tipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
