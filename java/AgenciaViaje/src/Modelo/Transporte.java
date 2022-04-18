package Modelo;
import Repositorios.Servicio;

public class Transporte extends Servicio{

    private String tipo;

    public Transporte(double valor, String tipo) {
        super("Transporte", valor);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Transporte{" +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
