package paquete.clases;

public class Transporte extends Producto {
    private String tipo;

    public Transporte(String nombre, double costo, String tipo) {
        super(nombre, costo);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
