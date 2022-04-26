package modelo;

public class Moto extends Vehiculo{

    public Moto() {
    }

    public Moto(Double velocidad, Double aceleracion, Double anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, patente);
        this.peso = 300.0;
        this.ruedas = 2;
    }
}
