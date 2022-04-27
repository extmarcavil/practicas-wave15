package series;

public class Auto extends Vehiculo{

    public Auto(double velocidad, double aceleracion, double AnguloDeGiro, String patente) {
        super(velocidad, aceleracion, AnguloDeGiro, patente);
        super.ruedas = 4;
        super.peso = 1000;
    }
}
