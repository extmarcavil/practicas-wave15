package series;

public class Moto extends Vehiculo{

    public Moto(double velocidad, double aceleracion, double AnguloDeGiro, String patente) {
        super(velocidad, aceleracion, AnguloDeGiro, patente);
        super.ruedas = 2;
        super.peso = 300;
    }
}
