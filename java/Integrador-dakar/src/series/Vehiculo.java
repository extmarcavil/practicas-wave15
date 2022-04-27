package series;

public class Vehiculo {
    double velocidad;
    double aceleracion;
    double anguloGiro;
    String patente;
    double peso;
    int ruedas;

    public Vehiculo() {
    }

    public Vehiculo(double velocidad, double aceleracion, double anguloGiro, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloGiro = anguloGiro;
        this.patente = patente;
    }

    public String getPatente(){
        return this.patente;
    }

    public double getCalculo(){
        return (this.velocidad * 1 / 2 * this.aceleracion) / (this.anguloGiro * (this.peso - this.ruedas * 100));
    }
}
