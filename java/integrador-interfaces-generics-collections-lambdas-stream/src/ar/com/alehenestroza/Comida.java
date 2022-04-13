package ar.com.alehenestroza;

public class Comida extends Producto {
    private String tipoComida;

    public Comida(double costo, String tipoComida) {
        super("Comida", costo);
        this.tipoComida = tipoComida;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }
}
