package dakar;

public class Moto extends Vehiculo{

    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        super.setPeso(300);
        super.setRuedas(2);
    }

}
