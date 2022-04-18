package Modelo;
import Repositorios.Servicio;

public class Comida extends Servicio {

    private String tipo_comida;

    public Comida(double valor, String tipo_comida) {
        super("Comida", valor);
        this.tipo_comida = tipo_comida;
    }

    public String getTipo_comida() {
        return tipo_comida;
    }

    public void setTipo_comida(String tipo_comida) {
        this.tipo_comida = tipo_comida;
    }


    @Override
    public String toString() {
        return "Comida{" +
                "tipo_comida='" + tipo_comida + '\'' +
                '}';
    }
}
