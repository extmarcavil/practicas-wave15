package ejercicio2;

public class NoPerecedero extends Producto{

    private  String tipo;

    public NoPerecedero(String tipo) {
        this.tipo = tipo;
    }

    public NoPerecedero(String nomnbre, double precio, String tipo) {
        super(nomnbre, precio);
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

    @Override
    public String toString() {
        return "NoPerecedero{" +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
