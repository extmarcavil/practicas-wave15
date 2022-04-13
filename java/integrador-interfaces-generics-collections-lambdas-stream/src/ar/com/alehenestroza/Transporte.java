package ar.com.alehenestroza;

public class Transporte extends Producto {
    private String tipo;

    public Transporte(double costo, String tipo) {
        super("Transporte", costo);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
