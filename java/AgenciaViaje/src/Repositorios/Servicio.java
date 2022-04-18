package Repositorios;

public abstract class Servicio {

    private String nombre;
    private double valor;

    public Servicio(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public double getValor() {
        return valor;
    }
}
