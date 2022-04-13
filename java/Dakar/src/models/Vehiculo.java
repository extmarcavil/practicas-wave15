package models;

public abstract class Vehiculo {
    private Float velocidad;
    private Float aceleracion;
    private Float anguloDeGiro;
    private String patente;

    protected Float peso;
    protected Integer ruedas;

    public Vehiculo(Float velocidad, Float aceleracion, Float anguloDeGiro, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloDeGiro=" + anguloDeGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }

    public Float getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Float velocidad) {
        this.velocidad = velocidad;
    }

    public Float getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(Float aceleracion) {
        this.aceleracion = aceleracion;
    }

    public Float getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(Float anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Float getPeso() {
        return peso;
    }

    public Integer getRuedas() {
        return ruedas;
    }
}
