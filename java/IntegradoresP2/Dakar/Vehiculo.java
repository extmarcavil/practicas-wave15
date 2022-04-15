package IntegradoresP2.Dakar;

public class Vehiculo {
    private double velocidad;
    private double aceleracion;
    private double anguloGiro;
    private String patente;
    private double peso;
    private int ruedas;

    public Vehiculo(double velocidad, double aceleracion, double anguloGiro, String patente, double peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloGiro = anguloGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public double getAnguloGiro() {
        return anguloGiro;
    }

    public void setAnguloGiro(double anguloGiro) {
        this.anguloGiro = anguloGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Patente: " + patente;
    }

    public double getMax(){
        // Calcular el puntaje obtenido en la carrera.
        return (velocidad * aceleracion / 2) / (anguloGiro * (peso - (ruedas * 100)));
    }
}
