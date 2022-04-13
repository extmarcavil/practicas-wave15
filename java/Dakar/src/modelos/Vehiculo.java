package modelos;

public class Vehiculo {

    private double velocidad;
    private double aceleracion;
    private double anguloGiro;
    private double peso;
    private int ruedas;
    private String patente;

    public Vehiculo(double velocidad, double aceleracion, double anguloGiro, double peso, int ruedas, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloGiro = anguloGiro;
        this.peso = peso;
        this.ruedas = ruedas;
        this.patente = patente;
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    @Override
    public String toString() {
        return "Vehiculo\n" +
                "\tVelocidad: " + velocidad + "\n" +
                "\tAceleracion: " + aceleracion + "\n" +
                "\tAnguloGiro: " + anguloGiro + "\n" +
                "\tPeso: " + peso + "\n" +
                "\tRuedas: " + ruedas + "\n" +
                "\tPatente: " + patente;
    }
}
