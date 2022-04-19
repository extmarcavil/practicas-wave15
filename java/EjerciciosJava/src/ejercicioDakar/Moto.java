package ejercicioDakar;

public class Moto extends Vehiculo{
    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.peso = 300;
        this.ruedas = 2;
    }
}
