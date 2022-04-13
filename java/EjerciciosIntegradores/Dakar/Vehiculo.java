package EjerciciosIntegradores.Dakar;

public class Vehiculo {
    private double velocidad;
    private double aceleracion;
    private double anguloGiro;
    private double peso;
    private Integer ruedas;
    private String patente;
    private double performance;

    public Vehiculo(double velocidad, double aceleracion, double anguloGiro, double peso, Integer ruedas, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloGiro = anguloGiro;
        this.peso = peso;
        this.ruedas = ruedas;
        this.patente = patente;
        this.performance = velocidad * 0.5 * aceleracion / (anguloGiro * (peso - (ruedas * 100)));
    }

    public Vehiculo() {
    }

    public double getPerformance() {
        return performance;
    }

    public void setPerformance(double performance) {
        this.performance = performance;
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

    public Integer getRuedas() {
        return ruedas;
    }

    public void setRuedas(Integer ruedas) {
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
        StringBuilder sb = new StringBuilder();
        sb.append("Vehiculo con Patente: ").append(patente).append("\n");
        return sb.toString();
    }
}
