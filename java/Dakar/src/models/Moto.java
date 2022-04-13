package models;

public class Moto extends Vehiculo {
    public Moto(Float velocidad, Float aceleracion, Float anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        super.peso = 300F;
        super.ruedas = 2;
    }
}
