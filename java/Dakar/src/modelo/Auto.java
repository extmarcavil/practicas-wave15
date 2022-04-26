package modelo;

public class Auto extends Vehiculo{

    public Auto() {
    }

//    public Auto(Double velocidad, Double aceleracion, Double anguloGiro, String patente, Double peso, Integer ruedas) {
//        super(velocidad, aceleracion, anguloGiro, patente, peso, ruedas);
//        this.peso = 1000.0;
//    }

    public Auto(Double velocidad, Double aceleracion, Double anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, patente);
        this.peso = 1000.0;
        this.ruedas = 4;
    }
}
